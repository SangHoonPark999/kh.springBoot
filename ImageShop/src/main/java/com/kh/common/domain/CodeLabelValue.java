package com.kh.common.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
@Data
public class CodeLabelValue {
	private final String value;
	private final String label;
}
