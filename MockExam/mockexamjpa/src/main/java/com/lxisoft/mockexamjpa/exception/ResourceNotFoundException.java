package com.lxisoft.mockexamjpa.exception;

public class ResourceNotFoundException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1351685903984983946L;
	
	public ResourceNotFoundException(Object resourId) {
        super(resourId != null ? resourId.toString() : null);
    }
	
}
