package br.ucsal.unimed.regras;

import java.util.List;

public class FilaMedicos {
	private static List<MedicoBO> medicosBO;

	public void adicionarMedicos(MedicoBO meBo) {
		if (!medicosBO.contains(meBo)) {
			medicosBO.add(meBo);
		}
	}

	public static List<MedicoBO> getMedicosBO() {
		return medicosBO;
	}

	public static void setMedicosBO(List<MedicoBO> medicosBO) {
		FilaMedicos.medicosBO = medicosBO;
	}
}
