package com.clinical.medical.crud;

import com.clinical.medical.crud.controller.MedicoController;
import com.clinical.medical.crud.model.Datas;
import com.clinical.medical.crud.model.dto.DatasDTO;
import com.clinical.medical.crud.model.dto.MedicoDTO;
import com.clinical.medical.crud.repository.DatasRepository;
import com.clinical.medical.crud.repository.MedicoRepository;
import com.clinical.medical.crud.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class AppClinicaMedicaApplication implements CommandLineRunner {

//	@Autowired
//	MedicoRepository medicoRepository;
//	@Autowired
//	MedicoService medicoService;
//	@Autowired
//	MedicoController medicoController;
//	@Autowired
//	DatasRepository datasRepository;
	public static void main(String[] args) {
		SpringApplication.run(AppClinicaMedicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
//		DatasDTO datasDTO = new DatasDTO("r","73","r@r","r,ps");
//		Datas datas = datasDTO.toConverterDatasDTO();
//		MedicoDTO medicoDTO = new MedicoDTO(3547,datas);
//		//errado //medicoRepository.save(medicoDTO);
//		medicoService.saveMedico(medicoDTO);
//		medicoController.save(medicoDTO);

	}
}
