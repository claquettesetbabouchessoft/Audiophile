package fr.claquettesetbabouchessoft.audiophile.utils;

import java.util.concurrent.Semaphore;

public class QAQueue<T, V> {

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
			sputQ.acquire();
			this.question = question;
			stakeQ.release();
			
			stakeA.acquire();
			V answer = this.answer;
			sputQ.release();
			return answer;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public T getQuestion() {
		try {
			stakeQ.acquire();
			T question = this.question;
			sputA.release();
			return question;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setAnswer(V answer) {
		try {
			sputA.acquire();
			this.answer = answer;
			stakeA.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
