package org.streampipes.storage.api;

import java.util.List;

import org.streampipes.model.client.pipeline.PipelineCategory;

public interface IPipelineCategoryStorage {

	List<PipelineCategory> getPipelineCategories();
	
	boolean addPipelineCategory(PipelineCategory pipelineCategory);
	
	boolean deletePipelineCategory(String categoryId);
	
}