package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LibraryDto;
import com.example.demo.service.LibraryService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RequestMapping(value = "/Library")
@RestController
public class LibraryController {
	@Autowired
	private LibraryService libraryService;

	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibraryDto> createLibrary(@Valid @RequestBody LibraryDto libdto) {
		LibraryDto lib = libraryService.creatLibrary(libdto);
		if (lib == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else

			return new ResponseEntity<>(lib, HttpStatus.OK);

	}
	@GetMapping(value="/getLibrary/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibraryDto>getLibrarybyId(@PathVariable(value="id") /*@RequestParam(value="name") */int id/*,String name*/){
		LibraryDto lib=libraryService.geLibrarybyId(id);
		if(lib==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>(lib, HttpStatus.OK);
		
		}
		
	}
	@GetMapping(value="/getAll",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LibraryDto>>getAllLibrary(){
		
	List<LibraryDto>liblist=libraryService.findAll();
	return new ResponseEntity<>(liblist,HttpStatus.OK);
			
	}
	
	@DeleteMapping( value = "/delete/{id}", produces = MediaType.TEXT_PLAIN_VALUE )
    public ResponseEntity<Boolean> deleteStoreById( @PathVariable( value = "id" ) int id )
    {
        boolean isDeleted = libraryService.deletedBtId( id );

        return new ResponseEntity<>( isDeleted, HttpStatus.NO_CONTENT );
    }
	@PutMapping(value ="update/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibraryDto>updateLibrary(@PathVariable int id, @RequestBody LibraryDto libdto){
		LibraryDto updatedLibrary = libraryService.updateLibrary( id, libdto );
        if( updatedLibrary == null )
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

        return new ResponseEntity<>( updatedLibrary, HttpStatus.OK );	
	}

    @DeleteMapping( value = "/deleteAll", produces = MediaType.TEXT_PLAIN_VALUE )
    public ResponseEntity<Boolean> deleteAllStores()
    {
        boolean isDeleted = libraryService.deleteAlllibrary();

        return new ResponseEntity<>( isDeleted, HttpStatus.NO_CONTENT );
    }
    
    
    
    @GetMapping(value="/FilteringValuebyId/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MappingJacksonValue>getFilteringValue(@PathVariable(value="id") int id){
		LibraryDto lib=libraryService.geLibrarybyId(id);
		SimpleBeanPropertyFilter  filter=SimpleBeanPropertyFilter.filterOutAllExcept("book_Id","liNo");
		FilterProvider filters=new SimpleFilterProvider().addFilter("beanpropertyfilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(lib);
		mapping.setFilters(filters);
		return new  ResponseEntity<>(mapping,HttpStatus.ACCEPTED);
   
    }
	@GetMapping("/gitWork")
	public String gdetdummyValutocheckgitPullis working()
	{
	  	return "Code From GitHub Remote Repository to Local Repository";
	}
