package com.LMG.web.stepdefinitions;

import cucumber.runtime.ParameterInfo;
import cucumber.runtime.StepDefinition;
import gherkin.I18n;
import gherkin.formatter.Argument;
import gherkin.formatter.model.Step;
import org.junit.Before;

import java.lang.reflect.Type;
import java.util.List;

public class Hooks {
    @Before
    public void beforeScenario(){
        StepDefinition m=new StepDefinition() {
            @Override
            public List<Argument> matchedArguments(Step step) {
                return null;
            }

            @Override
            public String getLocation(boolean detail) {
                return null;
            }

            @Override
            public Integer getParameterCount() {
                return null;
            }

            @Override
            public ParameterInfo getParameterType(int n, Type argumentType) throws IndexOutOfBoundsException {
                return null;
            }

            @Override
            public void execute(I18n i18n, Object[] args) throws Throwable {

            }

            @Override
            public boolean isDefinedAt(StackTraceElement stackTraceElement) {
                return false;
            }

            @Override
            public String getPattern() {
                return null;
            }

            @Override
            public boolean isScenarioScoped() {
                return false;
            }
        };

    }
}
