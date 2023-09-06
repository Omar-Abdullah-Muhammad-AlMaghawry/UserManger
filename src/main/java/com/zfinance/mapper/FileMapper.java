package com.zfinance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.zfinance.orm.profile.File;
import com.zfinance.orm.userdefinedtypes.profile.FileType;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FileMapper {

	FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);

	public FileType mapFileType(File file);

	public File mapFileType(FileType fileType);

	public List<FileType> mapFiles(List<File> files);

}
