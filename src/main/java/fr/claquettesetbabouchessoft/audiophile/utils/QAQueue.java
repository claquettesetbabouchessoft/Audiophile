package fr.claquettesetbabouchessoft.audiophile.utils;

import java.util.concurrent.Semaphore;

import fr.claquettesetbabouchessoft.audiophile.db.query.request.DBRequest;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBResult;

public class QAQueue<T extends DBRequest, V extends DBResult> {

	private Semaphore sputQ, stakeQ, sputA, stakeA;
	private T question;
	private V answer;
	
	public QAQueue() {
		this.sputQ = new Semaphore(1, true);
		this.stakeQ = new Semaphore(0, false);
		this.sputA = new Semaphore(0, false);
		this.stakeA = new Semaphore(0, false);
	}
	
	public V get(T question) {
		try {
			//System.out.println(Thread.currentThread().getName()+" > waiting for putting question...");
			sputQ.acquire();
			//System.out.println(Thread.currentThread().getName()+" > putting question...");
			this.question = question;
			stakeQ.release();
			
			//System.out.println(Thread.currentThread().getName()+" > waiting for taking answer...");
			stakeA.acquire();
			V answer = this.answer;
			//System.out.println(Thread.currentThread().getName()+" > taking answer...");
			sputQ.release();
			return answer;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public T getQuestion() {
		try {
			//System.out.println(Thread.currentThread().getName()+" > waiting for taking question...");
			stakeQ.acquire();
			T question = this.question;
			//System.out.println(Thread.currentThread().getName()+" > taking question...");
			sputA.release();
			return question;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setAnswer(V answer) {
		try {
			//System.out.println(Thread.currentThread().getName()+" > waiting for putting answer...");
			sputA.acquire();
			this.answer = answer;
			//System.out.println(Thread.currentThread().getName()+" > putting answer...");
			stakeA.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void shutdown() {
		//release take question semaphores and set question and answer to null meaning it's an error
		this.question = null;
		this.answer = null;
		stakeQ.release();
	}
}
