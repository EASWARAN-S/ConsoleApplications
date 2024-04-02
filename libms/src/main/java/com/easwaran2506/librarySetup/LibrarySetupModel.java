package com.easwaran2506.librarySetup;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.easwaran2506.dataLayer.LibraryDatabase;
import com.easwaran2506.model.Library;

class LibrarySetupModel {

	private LibrarySetupView librarySetupView;

	int libraryId;

	LibrarySetupModel(LibrarySetupView librarySetupView) {
		this.librarySetupView = librarySetupView;

	}

	List<Library> libraryList = new ArrayList<>();

	public List<Library> getLibrary() {
		return LibraryDatabase.getInstance().readLibrary();
	}

	public boolean isEmailAlreadyExists(String email) {
		boolean isEmail = false;
		if (libraryList.isEmpty())
			isEmail = true;
		else {
			for (int i = 0; i < libraryList.size(); i++) {
				if (libraryList.get(i).getEmailId().equals(email.toLowerCase()))
					isEmail = true;
			}
		}

		return isEmail;
	}

	public void setlibraryId() {
		if (LibraryDatabase.getInstance().readLibrary() == null)
			libraryId = 1;
		else {
			libraryList = LibraryDatabase.getInstance().readLibrary();
			libraryId = libraryList.get(libraryList.size() - 1).getLibraryId() + 1;
		}

	}

	public boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}

	public void addLibrary(String libName, String libEmail, String libAddr, String libIncharge, String libMobile) {

		setlibraryId();
		if (isValidEmail(libEmail)) {
			if (!isEmailAlreadyExists(libEmail)) {
				Library library = new Library();
				library.setLibraryId(libraryId);
				library.setLibraryActiveStatus(1);
				library.setEmailId(libEmail);
				library.setLibraryAddress(libAddr);
				library.setLibraryInchargeName(libIncharge);
				library.setLibraryName(libName);
				library.setPhoneNo(libMobile);
				libraryList.add(library);
				LibraryDatabase.getInstance().writeLibrary(libraryList);
			} else {
				librarySetupView.showAlert("Library Already exists with this Email Give Unique Email");
			}
		}

	}
}
