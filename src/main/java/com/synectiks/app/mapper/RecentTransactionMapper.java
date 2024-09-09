package com.synectiks.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecentTransactionMapper {
	RecentTransactionMapper INSTANCE=Mappers.getMapper(RecentTransactionMapper.class);
}
