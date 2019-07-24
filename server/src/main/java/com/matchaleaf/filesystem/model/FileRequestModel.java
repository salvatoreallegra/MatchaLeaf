//package com.matchaleaf.filesystem.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Lob;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//
//public class FileRequestModel {
//	
//	
//	public class DBFile {
//	   
//	   
//		private String fileName;
//
//	    private String fileType;
//	    
//	    private boolean isFolder;
//
//	    
//	    private byte[] data;
//
//	    public DBFile() {
//
//	    }
//
//	    public DBFile(String fileName, String fileType, byte[] data) {
//	        this.fileName = fileName;
//	        this.fileType = fileType;
//	        this.data = data;
//	    }
//	    
//
//		public String getFileName() {
//			return fileName;
//		}
//
//		public void setFileName(String fileName) {
//			this.fileName = fileName;
//		}
//
//		public String getFileType() {
//			return fileType;
//		}
//
//		public void setFileType(String fileType) {
//			this.fileType = fileType;
//		}
//
//		public boolean isFolder() {
//			return isFolder;
//		}
//
//		public void setFolder(boolean isFolder) {
//			this.isFolder = isFolder;
//		}
//
//		public byte[] getData() {
//			return data;
//		}
//
//		public void setData(byte[] data) {
//			this.data = data;
//		}
//
//	}
//
//}
