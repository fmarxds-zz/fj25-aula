package br.com.caelum.financas.service;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Singleton
@AccessTimeout(unit = TimeUnit.SECONDS, value = 5)
public class Agendador {

	@Resource
	private TimerService timer;
	
	private static int totalCriado;

	public void executa() {
		System.out.printf("\n%d instancias criadas %n", totalCriado);

		// simulando demora de 4s na execucao
		try {
			System.out.printf("Executando %s %n", this);
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
	}
	
	public void agenda(String expressaoMinutos, String expressaoSegundos) {
		ScheduleExpression exp = new ScheduleExpression();
		exp.hour("*");
		exp.minute(expressaoMinutos);
		exp.second(expressaoSegundos);
		
		TimerConfig config = new TimerConfig();
		config.setInfo(exp.toString());
		config.setPersistent(false);
		
		this.timer.createCalendarTimer(exp, config);
		
		System.out.printf("Agendamento: %s%n", exp);
	}
	
	@Schedule(
			hour="*",
			minute="*/1",
			second="0",
			persistent=false)
	public void enviaEmailScheduled() {
		System.out.println("\nEnviando email...\n");
	}
	
	@Timeout
	public void timerAcionado(Timer timer) {
		System.out.printf("Timer acionado: %s%n", timer.getInfo());
	}
	
	@PostConstruct
	void postConstrucao() {
		System.out.println("\ncriando agendador\n");
		totalCriado++;
	}
	
	@PreDestroy
	void preDestruicao() {
		System.out.println("\ndestruindo agendador\n");
	}

}
