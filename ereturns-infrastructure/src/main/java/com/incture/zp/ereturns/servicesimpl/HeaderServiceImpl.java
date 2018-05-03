package com.incture.zp.ereturns.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incture.zp.ereturns.dto.HeaderDto;
import com.incture.zp.ereturns.dto.ResponseDto;
import com.incture.zp.ereturns.model.Header;
import com.incture.zp.ereturns.repositories.HeaderRepository;
import com.incture.zp.ereturns.services.HeaderService;
import com.incture.zp.ereturns.utils.ImportExportUtil;

@Service
@Transactional
public class HeaderServiceImpl implements HeaderService {

	@Autowired
	HeaderRepository headerRepository;
	
	@Autowired
	ImportExportUtil importExportUtil;
	
	@Override
	public HeaderDto getHeaderById(String id) {
		Header header = headerRepository.getInvoiceById(id);
		
		return importExportUtil.exportHeaderDto(header);
	}

	@Override
	public ResponseDto addHeader(Header header) {
		return null;
	}

	@Override
	public ResponseDto updateHeader(Header header) {
		return null;
	}

	@Override
	public ResponseDto deleteHeader(String id) {
		return null;
	}

}
