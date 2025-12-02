package org.example;

import java.util.Scanner;

public class Main { // Ou Main

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Instancia o "trabalhador" (Serviço)
        CnpjService service = new CnpjService();

        System.out.print("Digite o CNPJ para consulta: ");
        String cnpjInput = scanner.nextLine();

        System.out.println("Consultando...");

        // 2. Chama o serviço (O Main não sabe como ele faz, só quer o resultado)
        CnpjData empresa = service.buscarCnpj(cnpjInput);

        // 3. Exibe o resultado
        if (empresa != null) {
            empresa.imprimirDetalhes();
        } else {
            System.out.println("Não foi possível encontrar dados para este CNPJ.");
        }

        scanner.close();
    }
}