package relatorio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface Relatorio {

	String gerar();

	default void salvarEmTxt(String caminho) throws IOException {
		Path arquivo = Paths.get(caminho);
		if (arquivo.getParent() != null) {
			Files.createDirectories(arquivo.getParent());
		}
		Files.write(arquivo, gerar().getBytes(StandardCharsets.UTF_8));
	}
}
