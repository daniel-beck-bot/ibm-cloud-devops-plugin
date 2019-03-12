/*
 <notice>

 Copyright 2017 IBM Corporation

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

 </notice>
 */

package com.ibm.devops.dra.steps;

import hudson.Extension;
import org.jenkinsci.plugins.workflow.steps.AbstractStepDescriptorImpl;
import org.jenkinsci.plugins.workflow.steps.AbstractStepImpl;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

import javax.annotation.Nonnull;

public class EvaluateGateStep extends AbstractDevOpsStep {

    // required parameters to support pipeline script
    private String policy;

    // optional gate parameters
    private String forceDecision;
    private String environment;
    private String buildNumber;
    private String appName;

    @DataBoundConstructor
    public EvaluateGateStep(String policy) {
        this.policy = policy;
    }

    @DataBoundSetter
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @DataBoundSetter
    public void setForceDecision(String forceDecision) {
        this.forceDecision = forceDecision;
    }

    @DataBoundSetter
    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }
    
    @DataBoundSetter
    public void setAppName(String appName) {
        this.appName = appName;
    }
    
    public String getAppName() {
    	return appName;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getPolicy() {
        return policy;
    }

    public String getForceDecision() {
        return forceDecision;
    }

    @Extension
    public static class DescriptorImpl extends AbstractStepDescriptorImpl {

        public DescriptorImpl() { super(EvaluateGateStepExecution.class); }

        @Override
        public String getFunctionName() {
            return "evaluateGate";
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return "IBM Cloud DevOps Gate";
        }
    }
}
