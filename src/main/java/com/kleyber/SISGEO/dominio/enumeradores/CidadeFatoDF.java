package com.kleyber.SISGEO.dominio.enumeradores;

public enum CidadeFatoDF {
    AGUAS_CLARAS("Águas Claras"),
    ARNIQUEIRA("Arniqueira"),
    BRASILIA("Brasília"),
    BRAZLANDIA("Brazlândia"),
    CANDANGOLANDIA("Candangolândia"),
    CEILANDIA("Ceilândia"),
    CRUZEIRO("Cruzeiro"),
    ESTRUTURAL("Estrutural"),
    FERCAL("Fercal"),
    GAMA("Gama"),
    GUARA("Guará"),
    ITAPOA("Itapoã"),
    JARDIM_BOTANICO("Jardim Botânico"),
    LAGO_NORTE("Lago Norte"),
    LAGO_SUL("Lago Sul"),
    NUCLEO_BANDEIRANTE("Núcleo Bandeirante"),
    OCTOGONAL("Octogonal"),
    PARANOÁ("Paranoá"),
    PARK_WAY("Park Way"),
    PLANALTINA("Planaltina"),
    RECANTO_DAS_EMAS("Recanto das Emas"),
    RIACHO_FUNDO("Riacho Fundo"),
    RIACHO_FUNDO_II("Riacho Fundo II"),
    SAMAMBAIA("Samambaia"),
    SANTA_MARIA("Santa Maria"),
    SAO_SEBASTIAO("São Sebastião"),
    SIA("SIA"),
    SOBRADINHO("Sobradinho"),
    SOBRADINHO_II("Sobradinho II"),
    SOL_NASCENTE_POR_DO_SOL("Sol Nascente/Por do Sol"),
    SUDOESTE("Sudoeste"),
    TAGUATINGA("Taguatinga"),
    VARJAO("Varjão"),
    VICENTE_PIRES("Vicente Pires");

    private final String nome;

    CidadeFatoDF(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

