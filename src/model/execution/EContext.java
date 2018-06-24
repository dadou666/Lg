package model.execution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import generer.Generateur;
import model.erreur.ErreurSemantique;
import model.semantique.Code;
import model.semantique.Univers;

public class EContext {
	public EUniversDef univers;
	public ECode code;
	public List<ErreurSemantique> erreurs = new ArrayList<>();

	public void calculer() {
		code = code.calculSymbolic(univers);
	}

	public void calculerSymbolic() {
		code = code.calculSymbolic(univers);
	}

	public String toString() {
		return code.afficher(univers);
	}

	public static EContext compilerCode(String src, Map<String, String> sources) {
		Generateur gen = new Generateur();
		Code code = gen.lireSourceCode(src);
		Set<String> modules = new HashSet<String>();
		code.donnerModules(modules);
		Univers u = new Univers();
		List<ErreurSemantique> erreurs = new ArrayList<>();
		for (String module : modules) {
			String s = module + ".mdl";
			
			Univers um =gen.cache.get(s);
			if (um == null) {
				um=gen.donnerUnivers(module + ".mdl", u, sources);
			
				if (um != null) {
					gen.cache.put(s,um);
					gen.modulesEnCours.remove(s);
					um.nom =module;
					//um.assignerModule(module);
				}
			}
			if (um != null) {
				u.ajouterImportModule(module, um);
				erreurs.addAll(u.erreurs);

			}

		}
		erreurs.addAll(gen.erreurs);
		EContext ctx = new EContext();
		EUniversDef univers = new EUniversDef();
		ctx.erreurs = erreurs;
		if (erreurs.isEmpty()) {
			u.compiler(null, univers);
			ctx.code = code.compiler(u, univers);
			univers.init();

		}
		return ctx;

	}

}
