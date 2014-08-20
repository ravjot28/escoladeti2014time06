package br.unicesumar.escoladeti.enums;

public enum StatusItem {
	ABERTO, ANDAMENTO, FINALIZADO, CANCELADO;

	public static StatusItem of(String status) {
		try {
			return valueOf(status);
		}catch(Exception e) {
			throw new RuntimeException("Status inválido para solicitacao item");
		}
	}

}
