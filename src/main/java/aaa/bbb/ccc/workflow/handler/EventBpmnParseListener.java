package aaa.bbb.ccc.workflow.handler;

import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.camunda.bpm.engine.impl.core.variable.mapping.IoMapping;
import org.camunda.bpm.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.camunda.bpm.engine.impl.pvm.PvmEvent;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.pvm.process.TransitionImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;
import org.camunda.bpm.engine.impl.variable.VariableDeclaration;

import java.util.List;

/**
 * Decide on which elements to add the listener. Allows to inspect basically everything
 * that happens within Camunda.
 */
public class EventBpmnParseListener implements BpmnParseListener {

    @Override
    public void parseProcess(Element processElement, ProcessDefinitionEntity processDefinition) {
        processDefinition.addBuiltInListener(PvmEvent.EVENTNAME_START, new StartEventListener());
        processDefinition.addBuiltInListener(PvmEvent.EVENTNAME_END, new EndEventListener());
    }

    @Override
    public void parseIntermediateThrowEvent(Element intermediateEventElement, ScopeImpl scope, ActivityImpl activity) {
        activity.addBuiltInListener(PvmEvent.EVENTNAME_START, new StartEventListener());
    }

    @Override
    public void parseStartEvent(Element startEventElement, ScopeImpl scope, ActivityImpl startEventActivity) {
    }

    @Override
    public void parseExclusiveGateway(Element exclusiveGwElement, ScopeImpl scope, ActivityImpl activity) {

    }

    @Override
    public void parseInclusiveGateway(Element inclusiveGwElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseParallelGateway(Element parallelGwElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseScriptTask(Element scriptTaskElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseServiceTask(Element serviceTaskElement, ScopeImpl scope, ActivityImpl activity) {
        activity.addListener(ExecutionListener.EVENTNAME_START, new ServiceEventListener());
    }

    @Override
    public void parseBusinessRuleTask(Element businessRuleTaskElement, ScopeImpl scope, ActivityImpl activity) {
        activity.addListener(ExecutionListener.EVENTNAME_START, new BusinessEventListener());
    }

    @Override
    public void parseTask(Element taskElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseManualTask(Element manualTaskElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseUserTask(Element userTaskElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseEndEvent(Element endEventElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseBoundaryTimerEventDefinition(Element timerEventDefinition, boolean interrupting, ActivityImpl timerActivity) {
    }

    @Override
    public void parseBoundaryErrorEventDefinition(Element errorEventDefinition, boolean interrupting, ActivityImpl activity,
                                                  ActivityImpl nestedErrorEventActivity) {
    }

    @Override
    public void parseSubProcess(Element subProcessElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseCallActivity(Element callActivityElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseProperty(Element propertyElement, VariableDeclaration variableDeclaration, ActivityImpl activity) {
    }

    @Override
    public void parseSequenceFlow(Element sequenceFlowElement, ScopeImpl scopeElement, TransitionImpl transition) {
    }

    @Override
    public void parseSendTask(Element sendTaskElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseMultiInstanceLoopCharacteristics(Element activityElement, Element multiInstanceLoopCharacteristicsElement, ActivityImpl activity) {
    }

    @Override
    public void parseIntermediateTimerEventDefinition(Element timerEventDefinition, ActivityImpl timerActivity) {
    }

    @Override
    public void parseRootElement(Element rootElement, List<ProcessDefinitionEntity> processDefinitions) {
    }

    @Override
    public void parseReceiveTask(Element receiveTaskElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseIntermediateSignalCatchEventDefinition(Element signalEventDefinition, ActivityImpl signalActivity) {
    }

    @Override
    public void parseIntermediateMessageCatchEventDefinition(Element messageEventDefinition, ActivityImpl nestedActivity) {
    }

    @Override
    public void parseBoundarySignalEventDefinition(Element signalEventDefinition, boolean interrupting, ActivityImpl signalActivity) {
    }

    @Override
    public void parseEventBasedGateway(Element eventBasedGwElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseTransaction(Element transactionElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseCompensateEventDefinition(Element compensateEventDefinition, ActivityImpl compensationActivity) {
    }

    @Override
    public void parseIntermediateCatchEvent(Element intermediateEventElement, ScopeImpl scope, ActivityImpl activity) {
    }

    @Override
    public void parseBoundaryEvent(Element boundaryEventElement, ScopeImpl scopeElement, ActivityImpl nestedActivity) {
    }

    @Override
    public void parseBoundaryMessageEventDefinition(Element element, boolean interrupting, ActivityImpl messageActivity) {
    }

    @Override
    public void parseBoundaryEscalationEventDefinition(Element escalationEventDefinition, boolean interrupting, ActivityImpl boundaryEventActivity) {
    }

    @Override
    public void parseBoundaryConditionalEventDefinition(Element element, boolean interrupting, ActivityImpl conditionalActivity) {
    }

    @Override
    public void parseIntermediateConditionalEventDefinition(Element conditionalEventDefinition, ActivityImpl conditionalActivity) {
    }

    @Override
    public void parseConditionalStartEventForEventSubprocess(Element element, ActivityImpl conditionalActivity, boolean interrupting) {
    }

    @Override
    public void parseIoMapping(Element element, ActivityImpl activity, IoMapping ioMapping) {

    }

}
