package de.fzi.cep.sepa.storage.util;

import com.clarkparsia.empire.util.EmpireUtil;

import de.fzi.cep.sepa.model.impl.graph.SepDescription;
import de.fzi.cep.sepa.storage.controller.StorageManager;

public class StorageUtils {
	
	public static void fixEmpire()
	{
		 EmpireUtil.all(StorageManager.INSTANCE.getEntityManager(), 
				 SepDescription.class); 
	}
}