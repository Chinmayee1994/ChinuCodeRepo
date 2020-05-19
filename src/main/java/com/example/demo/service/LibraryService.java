package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LibraryDto;
import com.example.demo.entity.Library;
import com.example.demo.repository.LibraryRepository;
@Service
public class LibraryService {

	@Autowired
	private LibraryRepository libraryRepositoory;

	private ModelMapper modelMapper;

	public LibraryService() {
		modelMapper = new ModelMapper();
	}

	private LibraryDto convertToDto(Library library) {

		return modelMapper.map(library, LibraryDto.class);
	}

	private Library convertToEntity(LibraryDto librarydto) {

		return modelMapper.map(librarydto, Library.class);

	}
	public LibraryDto creatLibrary(LibraryDto libray) {
		LibraryDto lib=null;
		
		Library libr=convertToEntity(libray);
		Library newlibr=libraryRepositoory.save(libr);
		
		lib=convertToDto(newlibr);
		return lib;
		
		
	}
public  LibraryDto geLibrarybyId(int libNo) {
	
	Library lib=libraryRepositoory.findById(libNo).get();
	return convertToDto(lib);
	
}
public List<LibraryDto>findAll(){
	List<Library>lib=libraryRepositoory.findAll();
	List<LibraryDto>libdto=lib.stream().map(entity->this.convertToDto(entity)).collect(Collectors.toList());
	return libdto;
}
public LibraryDto updateLibrary(int libId,LibraryDto newlib) {
	Library lib=this.convertToEntity(newlib);
	lib.setLiNo(libId);
	Library libentity=libraryRepositoory.save(lib);
	LibraryDto libdto=  this.convertToDto(libentity);
	return libdto;
	
}
public boolean deletedBtId(int libId) {
	libraryRepositoory.deleteById(libId);
	return true;

}
public boolean deleteAlllibrary() {
	libraryRepositoory.deleteAll();
	return true;
}


	

}
