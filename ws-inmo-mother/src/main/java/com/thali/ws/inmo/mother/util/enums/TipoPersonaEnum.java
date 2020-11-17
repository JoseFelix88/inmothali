package com.thali.ws.inmo.mother.util.enums;

/**
 * <p>Clase utilizada para determinar el valor constante perteneciente a TipoPersonaEnum.</p>
 * <p>Propiedades JURIDICA y NATURAL.</p>
 * @author Indra 
 */

public enum TipoPersonaEnum {
	
	/** The juridica. */
	JURIDICA	(2, "Jurídica", "PJ"),
	
	/** The natural. */
	NATURAL		(1, "Natural", "PN");
	
	/** The codigo. */
	private final Integer codigo;
	
	/** The nombre. */
	private final String nombre;
	
	/** The sigla. */
	private String sigla;
	
	/**
	 * Instantiates a new tipo persona enum.
	 *
	 * @param codigo the codigo
	 * @param nombre the nombre
	 */
	TipoPersonaEnum(Integer codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	/**
	 * Instantiates a new tipo persona enum.
	 *
	 * @param codigo the codigo
	 * @param nombre the nombre
	 * @param sigla the sigla
	 */
	TipoPersonaEnum(Integer codigo, String nombre, String sigla) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.sigla = sigla;
	}

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Gets the sigla.
	 *
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * Obtener enum X codigo.
	 *
	 * @param codigo the codigo
	 * @return the tipo persona enum
	 */
	public static TipoPersonaEnum obtenerEnumXCodigo(Integer codigo) {
		for (TipoPersonaEnum tipoPersona : TipoPersonaEnum.values()) {
			if(tipoPersona.getCodigo().equals(codigo)) {
				return tipoPersona;
			}
		}
		throw new IllegalArgumentException("No se encontró un TipoPersona con código ["+ codigo + "].");
	}
	
	/**
	 * Obtener enum X sigla.
	 *
	 * @param sigla the sigla
	 * @return the tipo persona enum
	 */
	public static TipoPersonaEnum obtenerEnumXSigla(String sigla) {
		if(sigla != null) {
			for (TipoPersonaEnum tipoPersona : TipoPersonaEnum.values()) {
				if(tipoPersona.getSigla().equalsIgnoreCase(sigla)) {
					return tipoPersona;
				}
			}
		}
		throw new IllegalArgumentException("No se encontró un TipoPersona con sigla ["+ sigla + "].");
	}

}
