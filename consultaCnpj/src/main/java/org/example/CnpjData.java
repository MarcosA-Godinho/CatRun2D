package org.example;

public class CnpjData {
    // Nomes exatos usados pela ReceitaWS
    public String nome;         // Razão Social
    public String fantasia;     // Nome Fantasia
    public String email;
    public String telefone;     // Vem tudo num campo só
    public String situacao;     // "ATIVA", "BAIXADA"

    // Endereço
    public String logradouro;
    public String numero;
    public String bairro;
    public String municipio;
    public String uf;
    public String cep;

    // Método de impressão atualizado para os novos nomes
    public void imprimirDetalhes() {
        System.out.println("==================================================");
        System.out.println("            RELATÓRIO (FONTE: RECEITAWS)          ");
        System.out.println("==================================================");
        System.out.printf("Razão Social:    %s\n", formatarCampo(this.nome));
        System.out.printf("Nome Fantasia:   %s\n", formatarCampo(this.fantasia));
        System.out.printf("Situação:        %s\n", formatarCampo(this.situacao));
        System.out.println("--------------------------------------------------");
        System.out.println("CONTATO:");
        System.out.printf("Email:           %s\n", formatarCampo(this.email));
        System.out.printf("Telefone:        %s\n", formatarCampo(this.telefone));
        System.out.println("--------------------------------------------------");
        System.out.println("ENDEREÇO:");
        System.out.printf("%s, %s - %s\n", formatarCampo(this.logradouro), formatarCampo(this.numero), formatarCampo(this.bairro));
        System.out.printf("%s - %s | CEP: %s\n", formatarCampo(this.municipio), formatarCampo(this.uf), formatarCampo(this.cep));
        System.out.println("==================================================");
    }

    private String formatarCampo(String texto) {
        if (texto == null || texto.trim().isEmpty() || texto.equalsIgnoreCase("null")) {
            return "---";
        }
        return texto;
    }
}