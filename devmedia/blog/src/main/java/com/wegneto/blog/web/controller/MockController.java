package com.wegneto.blog.web.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.javafaker.Faker;
import com.wegneto.blog.entity.Autor;
import com.wegneto.blog.entity.Avatar;
import com.wegneto.blog.entity.Categoria;
import com.wegneto.blog.entity.Perfil;
import com.wegneto.blog.entity.Postagem;
import com.wegneto.blog.entity.Usuario;
import com.wegneto.blog.service.AutorService;
import com.wegneto.blog.service.AvatarService;
import com.wegneto.blog.service.CategoriaService;
import com.wegneto.blog.service.PostagemService;
import com.wegneto.blog.service.UsuarioService;
import com.wegneto.blog.util.MyReplaceString;

@Controller
@RequestMapping("mock")
public class MockController {

	private static Faker faker = new Faker();

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AvatarService avatarService;

	@Autowired
	private AutorService autorService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private PostagemService postagemService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String save() {
		criarCategorias();

		criarUsuarios();

		criarAutores();

		criarPosts();

		return "redirect:/";
	}

	private void criarPosts() {
		List<Autor> autores = autorService.findAll();
		for (Autor autor : autores) {
			for (int p = 0; p < autor.getId().intValue(); p++) {
				String titulo = faker.book().title();
				String permalink = MyReplaceString.formatarPermalink(titulo);

				while (titulo.length() > 60 || permalink.length() > 60
						|| postagemService.findByPermalink(permalink) != null) {
					titulo = faker.book().title();
					permalink = MyReplaceString.formatarPermalink(titulo);
				}

				Postagem postagem = new Postagem();
				postagem.setAutor(autor);
				postagem.setTitulo(titulo);
				postagem.setTexto(faker.lorem().paragraph(20));

				postagemService.saveOrUpdate(postagem);
			}
		}
	}

	private void criarAutores() {
		List<Usuario> usuarios = usuarioService.findAll();
		for (Usuario usuario : usuarios) {
			if (usuario.getPerfil().equals(Perfil.AUTOR)) {
				Autor autor = new Autor();
				autor.setNome(usuario.getNome());

				int q = new Random().nextInt(3);

				String biografia = faker.gameOfThrones().quote();
				while (biografia.length() > 255) {
					switch (q) {
					case 1:
						biografia = faker.yoda().quote();
						break;
					case 2:
						biografia = faker.harryPotter().quote();
						break;
					case 3:
						biografia = faker.matz().quote();
						break;
					default:
						biografia = faker.gameOfThrones().quote();
						break;
					}
				}

				autor.setBiografia(biografia);
				autor.setUsuario(usuario);
				autorService.save(autor);
			}
		}
	}

	private void criarUsuarios() {
		Avatar avatar = avatarService.findById(1L);

		int usuarioCount = 0;
		while (usuarioCount < 15) {
			String email = faker.internet().safeEmailAddress();
			boolean emailJaCadastrado = usuarioService.findByEmail(email) != null;

			String nome = faker.name().fullName();
			boolean nomeJaCadastrado = usuarioService.findByNome(nome) != null;

			if (!emailJaCadastrado && !nomeJaCadastrado) {
				Usuario usuario = new Usuario();
				usuario.setNome(faker.name().fullName());
				usuario.setSenha("1234");
				usuario.setEmail(email);

				Avatar userAvatar = new Avatar();
				try {
					URL url = new URL(faker.avatar().image());
					InputStream in = new BufferedInputStream(url.openStream());
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					int n = 0;
					while (-1 != (n = in.read(buf))) {
						out.write(buf, 0, n);
					}
					out.close();
					in.close();
					byte[] response = out.toByteArray();
					userAvatar.setAvatar(response);
				} catch (Exception e) {
				}

				userAvatar.setTitulo("avatar.jpg");
				userAvatar.setTipo("image/jpeg");

				usuario.setAvatar(userAvatar);

				if (usuarioCount % 2 == 0) {
					usuario.setPerfil(Perfil.AUTOR);
				} else {
					usuario.setPerfil(Perfil.LEITOR);
				}

				usuarioService.save(usuario);

				usuarioCount++;
			}
		}
	}

	private void criarCategorias() {
		for (int c = 0; c < 30; c++) {
			String descricao = faker.commerce().department();
			String permalink = MyReplaceString.formatarPermalink(descricao);
			while (descricao.length() > 30 || permalink.length() > 30
					|| categoriaService.findByDescricao(descricao) != null) {
				descricao = faker.commerce().department();
				permalink = MyReplaceString.formatarPermalink(descricao);
			}

			Categoria categoria = new Categoria();
			categoria.setDescricao(descricao);
			categoriaService.saveOrUpdate(categoria);
		}
	}

}
