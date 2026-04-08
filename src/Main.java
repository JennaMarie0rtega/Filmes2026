import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Filmes> filmes = FWriter.carregarFilmes();
        Scanner terminal = new Scanner(System.in);

        pl pularl = new pl();

        while(true) {

            System.out.println("\n\n\n\n\n");
            System.out.println("╔══════════════════════════╗");
            System.out.println("║                          ║");
            System.out.println("║    SHELBY COMPANY LTD.   ║");
            System.out.println("║  The Small Heath Rifles  ║");
            System.out.println("║                          ║");
            System.out.println("╠══════════════════════════╣");
            System.out.println("║                          ║");
            System.out.println("║     C I N E M I N H A    ║");
            System.out.println("║       R E S E N H A      ║");
            System.out.println("║                          ║");
            System.out.println("║       ── 365 DNI ──      ║");
            System.out.println("║                          ║");
            System.out.println("╚══════════════════════════╝");
            System.out.println("");
            System.out.println("[ Aperte ENTER para entrar ]");
            terminal.nextLine();

            pl.pularLinha(1000);

            System.out.println("[1] Registrar Novo Filme");
            System.out.println("\n");
            System.out.println("[2] Listar Filmes Assistidos");
            pl.pularLinha(5);
            String resposta = terminal.nextLine();

            if (resposta.equalsIgnoreCase("1")) {

                Filmes assistidos = new Filmes();

                System.out.println("Digite o nome do filme:");
                System.out.println("\n");
                assistidos.nome = terminal.nextLine();
                System.out.println("\n");

                //kayla Axé ioruba

                System.out.println("Digite a data em que assistiu:");
                System.out.println("\n");
                assistidos.data = terminal.nextLine();
                System.out.println("\n");

                System.out.println("Digite a sua nota (de 1 a 10):");
                System.out.println("\n");
                assistidos.avaliacao = terminal.nextDouble();
                terminal.nextLine();
                System.out.println("\n");

                System.out.println("Digite uma breve resenha sobre o filme, ou deixe em branco");
                System.out.println("\n");
                assistidos.resenha = terminal.nextLine();
                System.out.println("\n");

                filmes.add(assistidos);
                Writer.salvarFilmes(filmes);

                Thread.sleep(1000);
                // que toda umbanda do inferno atinja a Kayla e que ela fique possuida durante a madrugada ae
            } else if (resposta.equalsIgnoreCase("2")) {

                for (Filmes f : filmes) {
                    System.out.println("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
                    System.out.println("  Nome     : " + f.nome);
                    System.out.println("  Assistiu : " + f.data);
                    System.out.println("  Nota     : " + f.avaliacao);
                    System.out.println("  Resenha  : " + f.resenha);
                    System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
                }

                System.out.println("\n");
                System.out.println("Aperte ENTER para voltar ao início");
                System.out.println("\n");
                terminal.nextLine();
            }

        }


    }

    public class Writer {

        static void salvarFilmes(ArrayList<Filmes> filmes) {
            try {
                FileWriter fw = new FileWriter("assistidos.txt");
                for (Filmes f : filmes) {
                    fw.write(f.nome + "|" + f.data + "|" + f.avaliacao + "|" + f.resenha + "\n");
                }
                fw.close();
                System.out.println("Filme adicionado com sucesso!");
            } catch(Exception e) {
                System.out.println("Erro ao salvar. " + e.getMessage());
            }
        }

    }
}