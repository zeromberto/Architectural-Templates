package org.scaledl.architecturaltemplates.repositories.cloudscale.black;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.modelversioning.emfprofile.Stereotype;
import org.modelversioning.emfprofileapplication.StereotypeApplication;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

public class ThreeLayerLibrary {

	public ThreeLayerLibrary() {
		super();
	}
	
	public static double getResponseTimeThreshold(
			AssemblyContext assemblyContext, String taggedValueName,
			String stereotypeName) {
		return getValueOfDoubleTaggedValue(assemblyContext, taggedValueName, stereotypeName);	
	}
	
	public static double getResponseTimeInterval(
			AssemblyContext assemblyContext, String taggedValueName,
			String stereotypeName) {
		return getValueOfDoubleTaggedValue(assemblyContext, taggedValueName, stereotypeName);	
	}

	@SuppressWarnings("unchecked")
	private static <DATA_TYPE> DATA_TYPE getValueOfDoubleTaggedValue(
			Entity pcmEntity, String taggedValueName,
			String stereotypeName) {
		EList<StereotypeApplication> pcmEntityStereotypeApplications = pcmEntity
				.getStereotypeApplications(stereotypeName);
		StereotypeApplication stereotypeApplication = pcmEntityStereotypeApplications
				.get(0);

		Stereotype stereotype = stereotypeApplication.getStereotype();

		EStructuralFeature taggedValue = stereotype
				.getTaggedValue(taggedValueName);

		return (DATA_TYPE) stereotypeApplication.eGet(taggedValue);

	}
}