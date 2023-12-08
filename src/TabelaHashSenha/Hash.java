package TabelaHashSenha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Hash {
    private Map<String, String> tabelaSenha;

    public Hash() {
        tabelaSenha = new HashMap<>();
    }

    public String getHashSenha(String usuario) {
        return tabelaSenha.get(usuario);
    }

    public void addSenha(String usuario, String senha) {
        if (tabelaSenha.containsKey(usuario)) {
            System.out.println("Usuário já existente, por favor, selecione outro nome.");
            return;
        }
        String valorHashSenha = hashSenha(senha);
        tabelaSenha.put(usuario, valorHashSenha);
    }

    public boolean buscaSenha(String usuario, String senha) {
        String valorHashSenha = hashSenha(senha);
        return valorHashSenha.equals(tabelaSenha.get(usuario));
    }

    private String hashSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
