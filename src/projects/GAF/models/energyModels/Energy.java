/**
 * Classe Energia - Representa todas as informacões referente a energia de cada nó (dados em Joule)
 * @author João Danilo &lt; joaodanilo1992@gmail.com&gt;
 * @version 1.0, 24/01/16
 */
package projects.GAF.models.energyModels;

import java.util.Random;

public class Energy {
	
	/**Informa a energia atual da bateria */
	private double energiaAtual;
	
	/**Informa a energia máxima da bateria */
	private double energiaMax;
		
	/**Informa a quantidade de energia gasta para enviar um pacote (tempo de envio adotado de 1 segundo) */
	private final double consumoEnvio = 0.11385;
	
	/**Informa a quantidade de energia gasta para receber um pacote (tempo de recebimento adotado de 1 segundo) */
	private final double consumoRecebimento = 0.05973;
	
	/**Informa a quantidade de energia gasta no modo idle (tempo de idle adotado de 1 segundo)*/
	private final double consumoIdle = 0.01716;
	
	/**Informa a quantidade de energia gasta em modo Sleep (tempo de sleep adotado de 1 segundo) */
	private final double consumoModoSleep = 0.00099;
	
	/**Informa a quantidade de energia gerada pelo painel solar (tempo de geração adotado de 1 segundo) */
	private double energiaPainel;	
	
	/**Informa a potência máxima do painel solar (em W/m^2) */
	//private double wattPicoPainel;
	
	/**Informa a quantidade de energia gasta para sensoriar a umidade (tempo de sensoriamento adotado de 2 segundo) */
	private final double consumoDHT = 0.00858;
	
	Random random = new Random();
	
	/**
	 * Construtor da classe
	 * @param energiamax energia máxima da bateria
	 */	
	public Energy(double energiamax){
		
		
		this.energiaMax = energiamax + random.nextGaussian();
		this.energiaAtual = this.energiaMax ;
				
		//wattPicoPainel = Configuration.getDoubleParameter("WattPico/valor");
		//wattPicoPainel = 0;
		
	}
	
	/**
	 * Calcula o gasto de energia do envio de 1 pacote
	 */
	public void gastaEnergiaEnvio(){
		
		energiaAtual = energiaAtual - consumoEnvio;
				
	}
	
	/**
	 * Calcula o gasto de energia do modo idle
	 */
	public void gastaEnergiaIdle() {
		energiaAtual = energiaAtual - consumoIdle;
	}
	
	/**
	 * Calcula o gasto de energia  no modo de escuta de 1 pacote
	 */	
	public void gastaEnergiaRecebimento(){
		
		energiaAtual  = energiaAtual  - consumoRecebimento;
		
	}
	
	/**
	 * Calcula o gasto de energia no modo Sleep
	 */
	public void modoSleep(){
		
		energiaAtual = energiaAtual - consumoModoSleep;
	}
	
	/**
	 * Calcula a energia gera pela placa solar e adiciona na bateria
	 */
	public void recarrega(){
		
		//energiaPainel = ((CustomGlobal.intensidadeSolar * wattPicoPainel)) / 1000;
				
		//energiaAtual = energiaAtual + energiaPainel;
	}
	
	/**
	 * Calcula o gasto do sensor de umidade
	 */
	public void consumoDHT(){
		
		energiaAtual = energiaAtual - consumoDHT;
	}
	
	/**
	 * Informa a energia atual do nó
	 * @return double energiaAtual
	 */	
	public double getEnergiaAtual(){
		
		return energiaAtual ;
	}
	
	/**
	 * Informa quanto o nó gasta de energia para receber pacotes por 1 segundo
	 * @return double consumoRecebimento
	 */
	public double getEnergiaRecebimento(){
		
		return consumoRecebimento;
	}
	
	/**
	 * Informa quanto o nó gasta de energia para enviar 1 pacote
	 * @return double consumoEnvio
	 */
	public double getEnergiaEnvio(){
		
		return consumoEnvio;
	}
	
	/**
	 * Informa a energia máxima do nó
	 * @return double energiaMax
	 */
	public double getEnergiaMaxima(){
		
		return energiaMax;
	}
	
	/**
	 * Informa a energia atual gerada pelo painel solar
	 * @return double energiaPainel
	 */
	public double getEnergiaPainel(){
		
		return energiaPainel;
	}	
	
	
}
