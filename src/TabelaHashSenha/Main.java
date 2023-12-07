package TabelaHashSenha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hash tabelaHash = new Hash();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar conta");
            System.out.println("2. Login");
            System.out.println("3. Demonstrar valor hash da senha");
            System.out.println("4. Finalizar");
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o usuário: ");
                    String usuario = sc.nextLine();
                    System.out.print("Digite a senha: ");
                    String password = sc.nextLine();
                    tabelaHash.addSenha(usuario, password);
                    System.out.println("Conta criada com sucesso.");
                    break;

                case 2:
                    System.out.print("Digite o usuário: ");
                    String checkUsername = sc.nextLine();
                    System.out.print("Digite a senha: ");
                    String checkPassword = sc.nextLine();
                    boolean isCorrect = tabelaHash.buscaSenha(checkUsername, checkPassword);
                    if (isCorrect) {
                        System.out.println("Senha está correta. Login realizado");
                    } else {
                        System.out.println("Senha está incorreta.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o usuário: ");
                    usuario = sc.nextLine();
                    String hashedPassword = tabelaHash.getHashSenha(usuario);
                    if (hashedPassword != null) {
                        System.out.println("Valor hash da senha: " + hashedPassword);
                    } else {
                        System.out.println("Nenhuma conta encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("Finalizando programa.");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
