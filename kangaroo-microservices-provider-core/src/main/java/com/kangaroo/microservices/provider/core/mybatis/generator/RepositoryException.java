package com.kangaroo.microservices.provider.core.mybatis.generator;

public class RepositoryException extends RuntimeException{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepositoryException() {
	        super();
	    }

	    public RepositoryException(String message) {
	        super(message);
	    }

	    public RepositoryException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public RepositoryException(Throwable cause) {
	        super(cause);
	    }

}
