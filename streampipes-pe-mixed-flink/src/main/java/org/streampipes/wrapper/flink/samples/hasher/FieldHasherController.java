package org.streampipes.wrapper.flink.samples.hasher;

import org.streampipes.container.util.StandardTransportFormat;
import org.streampipes.wrapper.flink.AbstractFlinkAgentDeclarer;
import org.streampipes.wrapper.flink.FlinkDeploymentConfig;
import org.streampipes.wrapper.flink.FlinkSepaRuntime;
import org.streampipes.wrapper.flink.samples.Config;
import org.streampipes.model.impl.EventSchema;
import org.streampipes.model.impl.EventStream;
import org.streampipes.model.impl.eventproperty.EventProperty;
import org.streampipes.model.impl.graph.SepaDescription;
import org.streampipes.model.impl.graph.SepaInvocation;
import org.streampipes.model.impl.output.OutputStrategy;
import org.streampipes.model.impl.output.RenameOutputStrategy;
import org.streampipes.model.impl.staticproperty.MappingPropertyUnary;
import org.streampipes.model.impl.staticproperty.OneOfStaticProperty;
import org.streampipes.model.impl.staticproperty.Option;
import org.streampipes.model.impl.staticproperty.StaticProperty;
import org.streampipes.model.util.SepaUtils;

import java.util.ArrayList;
import java.util.List;

public class FieldHasherController extends AbstractFlinkAgentDeclarer<FieldHasherParameters> {

	@Override
	public SepaDescription declareModel() {
		List<EventProperty> eventProperties = new ArrayList<EventProperty>();		
		EventSchema schema1 = new EventSchema();
		schema1.setEventProperties(eventProperties);
		
		EventStream stream1 = new EventStream();
		stream1.setEventSchema(schema1);
		
		SepaDescription desc = new SepaDescription("fieldhasher", "Field Hasher", "The Field Hasher uses an algorithm to encode values in a field. The Field Hasher can use MD5, SHA1 or SHA2 to hash field values.");
		desc.setIconUrl(Config.getIconUrl("field-hasher-icon"));
		desc.addEventStream(stream1);
		
		List<StaticProperty> staticProperties = new ArrayList<>();
		staticProperties.add(new MappingPropertyUnary("property-mapping", "Field", "The field the hash function should be applied on"));
		OneOfStaticProperty algorithmSelection = new OneOfStaticProperty("hash-algorithm", "Hash Algorithm", "The hash algorithm that should be used.");
		algorithmSelection.addOption(new Option("SHA1"));
		algorithmSelection.addOption(new Option("SHA2"));
		algorithmSelection.addOption(new Option("MD5"));
		staticProperties.add(algorithmSelection);
		desc.setStaticProperties(staticProperties);
		
		List<OutputStrategy> strategies = new ArrayList<OutputStrategy>();
		RenameOutputStrategy keepOutput = new RenameOutputStrategy();
		
		strategies.add(keepOutput);
		desc.setOutputStrategies(strategies);
		desc.setSupportedGrounding(StandardTransportFormat.getSupportedGrounding());
		
		return desc;
	}

	@Override
	protected FlinkSepaRuntime<FieldHasherParameters> getRuntime(
			SepaInvocation graph) {
		String propertyName = SepaUtils.getMappingPropertyName(graph, "property-mapping");
		
		HashAlgorithmType hashAlgorithmType = HashAlgorithmType.valueOf(SepaUtils.getOneOfProperty(graph, "hash-algorithm"));
		
		return new FieldHasherProgram(
				new FieldHasherParameters(graph, propertyName, hashAlgorithmType),
				new FlinkDeploymentConfig(Config.JAR_FILE, Config.FLINK_HOST, Config.FLINK_PORT));
	}

}