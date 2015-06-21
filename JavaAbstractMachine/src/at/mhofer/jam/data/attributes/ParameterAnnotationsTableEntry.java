package at.mhofer.jam.data.attributes;

public class ParameterAnnotationsTableEntry
{
	private int numAnnotations;
	
	private AnnotationTableEntry[] annotations;

	public ParameterAnnotationsTableEntry(int numAnnotations, AnnotationTableEntry[] annotations)
	{
		super();
		this.numAnnotations = numAnnotations;
		this.annotations = annotations;
	}

	public int getNumAnnotations()
	{
		return numAnnotations;
	}

	public AnnotationTableEntry[] getAnnotations()
	{
		return annotations;
	}
}
