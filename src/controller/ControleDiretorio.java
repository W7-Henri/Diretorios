package controller;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class ControleDiretorio {

    /**
     * Lista os arquivos de um diretório, ordenados por tamanho em MB.
     * 
     * @param caminhoDiretorio O caminho do diretório.
     */
    public void listarArquivosPorTamanho(String caminhoDiretorio) {
        // Cria um objeto File com o caminho recebido
        File diretorio = new File(caminhoDiretorio);

        // Valida se o caminho existe e se é um diretório
        if (!diretorio.exists()) {
            System.out.println("O diretório não existe.");
            return;
        }

        if (!diretorio.isDirectory()) {
            System.out.println("O caminho especificado não é um diretório.");
            return;
        }

        // Lista apenas os arquivos (não diretórios)
        File[] arquivos = diretorio.listFiles(File::isFile);

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Não há arquivos no diretório.");
            return;
        }

        // Ordena os arquivos pelo tamanho (em bytes), do menor para o maior
        Arrays.sort(arquivos, Comparator.comparingLong(File::length));

        // Exibe os arquivos com tamanho em MB
        System.out.println("Arquivos no diretório '" + caminhoDiretorio + "' ordenados por tamanho:");
        for (File arquivo : arquivos) {
            double tamanhoMB = arquivo.length() / (1024.0 * 1024.0);
            System.out.printf("%s - %.2f MB%n", arquivo.getName(), tamanhoMB);
        }
    }

    // Método main para testar a funcionalidade
    public static void main(String[] args) {
        ControleDiretorio controle = new ControleDiretorio();

        String caminho = "C:\\Users\\note";

        controle.listarArquivosPorTamanho(caminho);
    }
}
