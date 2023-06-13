package aaa.bbb.ccc.workflow.handler;

import org.camunda.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * A {@link ProcessEnginePlugin} just needs to be a spring bean in order
 * to get automatically registered in the Spring Boot environment.
 */
@Component
public class EventListenerPlugin extends AbstractProcessEnginePlugin {

	@Override
	public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
		if (processEngineConfiguration.getCustomPostBPMNParseListeners() == null) {
			processEngineConfiguration.setCustomPostBPMNParseListeners(new ArrayList<BpmnParseListener>());
		}
		processEngineConfiguration.getCustomPostBPMNParseListeners().add(new EventBpmnParseListener());

	}

}
