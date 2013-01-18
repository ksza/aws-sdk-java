/*
 * Copyright 2010-2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.elasticmapreduce.model;
import com.amazonaws.AmazonWebServiceRequest;

/**
 * Container for the parameters to the {@link com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduce#runJobFlow(RunJobFlowRequest) RunJobFlow operation}.
 * <p>
 * RunJobFlow creates and starts running a new job flow. The job flow will run the steps specified. Once the job flow completes, the cluster is stopped
 * and the HDFS partition is lost. To prevent loss of data, configure the last step of the job flow to store results in Amazon S3. If the
 * JobFlowInstancesConfig <code>KeepJobFlowAliveWhenNoSteps</code> parameter is set to <code>TRUE</code> , the job flow will transition to the WAITING
 * state rather than shutting down once the steps have completed.
 * </p>
 * <p>
 * For additional protection, you can set the JobFlowInstancesConfig <code>TerminationProtected</code> parameter to <code>TRUE</code> to lock the job
 * flow and prevent it from being terminated by API call, user intervention, or in the event of a job flow error.
 * </p>
 * <p>
 * A maximum of 256 steps are allowed in each job flow.
 * </p>
 * <p>
 * If your job flow is long-running (such as a Hive data warehouse) or complex, you may require more than 256 steps to process your data. You can bypass
 * the 256-step limitation in various ways, including using the SSH shell to connect to the master node and submitting queries directly to the software
 * running on the master node, such as Hive and Hadoop. For more information on how to do this, go to <a
 * href="http://docs.amazonwebservices.com/ElasticMapReduce/latest/DeveloperGuide/AddMoreThan256Steps.html"> Add More than 256 Steps to a Job Flow </a>
 * in the <i>Amazon Elastic MapReduce Developer's Guide</i> .
 * </p>
 * <p>
 * For long running job flows, we recommend that you periodically store your results.
 * </p>
 *
 * @see com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduce#runJobFlow(RunJobFlowRequest)
 */
public class RunJobFlowRequest extends AmazonWebServiceRequest {

    /**
     * The name of the job flow.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 256<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     */
    private String name;

    /**
     * Specifies the location in Amazon S3 to write the log files of the job
     * flow. If a value is not provided, logs are not created.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 10280<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     */
    private String logUri;

    /**
     * A JSON string for selecting additional features.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 10280<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     */
    private String additionalInfo;

    /**
     * The version of the Amazon Machine Image (AMI) to use when launching
     * Amazon EC2 instances in the job flow. The following values are valid:
     * <ul> <li>"latest" (latest AMI version; currently AMI 2.0, Hadoop
     * 0.20.205)</li> <li>"2.0" (AMI 2.0, Hadoop 0.20.205)</li> <li>"1.0"
     * (AMI 1.0, Hadoop 0.18)</li> </ul> <p>If this value is not specified,
     * the job flow uses the default of (AMI 1.0, Hadoop 0.18). <p>If the AMI
     * supports multiple versions of Hadoop (for example, AMI 1.0 supports
     * both Hadoop 0.18 and 0.20) you can use the
     * <a>JobFlowInstancesConfig</a> <code>HadoopVersion</code> parameter to
     * modify the version of Hadoop from the defaults shown above. <p>For
     * details about the AMI versions currently supported by Amazon
     * ElasticMapReduce, go to <a
     * perGuide/EnvironmentConfig_AMIVersion.html#ami-versions-supported">AMI
     * Versions Supported in Elastic MapReduce</a> in the <i>Amazon Elastic
     * MapReduce Developer's Guide.</i>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 256<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     */
    private String amiVersion;

    /**
     * A specification of the number and type of Amazon EC2 instances on
     * which to run the job flow.
     */
    private JobFlowInstancesConfig instances;

    /**
     * A list of steps to be executed by the job flow.
     */
    private java.util.List<StepConfig> steps;

    /**
     * A list of bootstrap actions that will be run before Hadoop is started
     * on the cluster nodes.
     */
    private java.util.List<BootstrapActionConfig> bootstrapActions;

    /**
     * A list of strings that indicates third-party software to use with the
     * job flow. For more information, go to <a
     * lasticMapReduce/latest/DeveloperGuide/emr-supported-products.html">Use
     * Third Party Applications with Amazon EMR</a>. Currently supported
     * values are: <ul> <li>"karmasphere-enterprise-utility" - tag the job
     * flow for management by <a
     * ://aws.amazon.com/elasticmapreduce/karmasphere/">Karmasphere.</a></li>
     * <li>"mapr-m3" - launch the job flow using MapR M3 Edition.</li>
     * <li>"mapr-m5" - launch the job flow using MapR M5 Edition.</li> </ul>
     */
    private java.util.List<String> supportedProducts;

    /**
     * Whether the job flow is visible to all IAM users of the AWS account
     * associated with the job flow. If this value is set to
     * <code>true</code>, all IAM users of that AWS account can view and (if
     * they have the proper policy permissions set) manage the job flow. If
     * it is set to <code>false</code>, only the IAM user that created the
     * job flow can view and manage it.
     */
    private Boolean visibleToAllUsers;

    /**
     * Default constructor for a new RunJobFlowRequest object.  Callers should use the
     * setter or fluent setter (with...) methods to initialize this object after creating it.
     */
    public RunJobFlowRequest() {}
    
    /**
     * Constructs a new RunJobFlowRequest object.
     * Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param name The name of the job flow.
     * @param instances A specification of the number and type of Amazon EC2
     * instances on which to run the job flow.
     */
    public RunJobFlowRequest(String name, JobFlowInstancesConfig instances) {
        this.name = name;
        this.instances = instances;
    }

    
    
    /**
     * The name of the job flow.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 256<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @return The name of the job flow.
     */
    public String getName() {
        return name;
    }
    
    /**
     * The name of the job flow.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 256<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @param name The name of the job flow.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * The name of the job flow.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 256<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @param name The name of the job flow.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withName(String name) {
        this.name = name;
        return this;
    }
    
    
    /**
     * Specifies the location in Amazon S3 to write the log files of the job
     * flow. If a value is not provided, logs are not created.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 10280<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @return Specifies the location in Amazon S3 to write the log files of the job
     *         flow. If a value is not provided, logs are not created.
     */
    public String getLogUri() {
        return logUri;
    }
    
    /**
     * Specifies the location in Amazon S3 to write the log files of the job
     * flow. If a value is not provided, logs are not created.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 10280<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @param logUri Specifies the location in Amazon S3 to write the log files of the job
     *         flow. If a value is not provided, logs are not created.
     */
    public void setLogUri(String logUri) {
        this.logUri = logUri;
    }
    
    /**
     * Specifies the location in Amazon S3 to write the log files of the job
     * flow. If a value is not provided, logs are not created.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 10280<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @param logUri Specifies the location in Amazon S3 to write the log files of the job
     *         flow. If a value is not provided, logs are not created.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withLogUri(String logUri) {
        this.logUri = logUri;
        return this;
    }
    
    
    /**
     * A JSON string for selecting additional features.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 10280<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @return A JSON string for selecting additional features.
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }
    
    /**
     * A JSON string for selecting additional features.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 10280<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @param additionalInfo A JSON string for selecting additional features.
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    
    /**
     * A JSON string for selecting additional features.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 10280<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @param additionalInfo A JSON string for selecting additional features.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }
    
    
    /**
     * The version of the Amazon Machine Image (AMI) to use when launching
     * Amazon EC2 instances in the job flow. The following values are valid:
     * <ul> <li>"latest" (latest AMI version; currently AMI 2.0, Hadoop
     * 0.20.205)</li> <li>"2.0" (AMI 2.0, Hadoop 0.20.205)</li> <li>"1.0"
     * (AMI 1.0, Hadoop 0.18)</li> </ul> <p>If this value is not specified,
     * the job flow uses the default of (AMI 1.0, Hadoop 0.18). <p>If the AMI
     * supports multiple versions of Hadoop (for example, AMI 1.0 supports
     * both Hadoop 0.18 and 0.20) you can use the
     * <a>JobFlowInstancesConfig</a> <code>HadoopVersion</code> parameter to
     * modify the version of Hadoop from the defaults shown above. <p>For
     * details about the AMI versions currently supported by Amazon
     * ElasticMapReduce, go to <a
     * perGuide/EnvironmentConfig_AMIVersion.html#ami-versions-supported">AMI
     * Versions Supported in Elastic MapReduce</a> in the <i>Amazon Elastic
     * MapReduce Developer's Guide.</i>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 256<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @return The version of the Amazon Machine Image (AMI) to use when launching
     *         Amazon EC2 instances in the job flow. The following values are valid:
     *         <ul> <li>"latest" (latest AMI version; currently AMI 2.0, Hadoop
     *         0.20.205)</li> <li>"2.0" (AMI 2.0, Hadoop 0.20.205)</li> <li>"1.0"
     *         (AMI 1.0, Hadoop 0.18)</li> </ul> <p>If this value is not specified,
     *         the job flow uses the default of (AMI 1.0, Hadoop 0.18). <p>If the AMI
     *         supports multiple versions of Hadoop (for example, AMI 1.0 supports
     *         both Hadoop 0.18 and 0.20) you can use the
     *         <a>JobFlowInstancesConfig</a> <code>HadoopVersion</code> parameter to
     *         modify the version of Hadoop from the defaults shown above. <p>For
     *         details about the AMI versions currently supported by Amazon
     *         ElasticMapReduce, go to <a
     *         perGuide/EnvironmentConfig_AMIVersion.html#ami-versions-supported">AMI
     *         Versions Supported in Elastic MapReduce</a> in the <i>Amazon Elastic
     *         MapReduce Developer's Guide.</i>
     */
    public String getAmiVersion() {
        return amiVersion;
    }
    
    /**
     * The version of the Amazon Machine Image (AMI) to use when launching
     * Amazon EC2 instances in the job flow. The following values are valid:
     * <ul> <li>"latest" (latest AMI version; currently AMI 2.0, Hadoop
     * 0.20.205)</li> <li>"2.0" (AMI 2.0, Hadoop 0.20.205)</li> <li>"1.0"
     * (AMI 1.0, Hadoop 0.18)</li> </ul> <p>If this value is not specified,
     * the job flow uses the default of (AMI 1.0, Hadoop 0.18). <p>If the AMI
     * supports multiple versions of Hadoop (for example, AMI 1.0 supports
     * both Hadoop 0.18 and 0.20) you can use the
     * <a>JobFlowInstancesConfig</a> <code>HadoopVersion</code> parameter to
     * modify the version of Hadoop from the defaults shown above. <p>For
     * details about the AMI versions currently supported by Amazon
     * ElasticMapReduce, go to <a
     * perGuide/EnvironmentConfig_AMIVersion.html#ami-versions-supported">AMI
     * Versions Supported in Elastic MapReduce</a> in the <i>Amazon Elastic
     * MapReduce Developer's Guide.</i>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 256<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @param amiVersion The version of the Amazon Machine Image (AMI) to use when launching
     *         Amazon EC2 instances in the job flow. The following values are valid:
     *         <ul> <li>"latest" (latest AMI version; currently AMI 2.0, Hadoop
     *         0.20.205)</li> <li>"2.0" (AMI 2.0, Hadoop 0.20.205)</li> <li>"1.0"
     *         (AMI 1.0, Hadoop 0.18)</li> </ul> <p>If this value is not specified,
     *         the job flow uses the default of (AMI 1.0, Hadoop 0.18). <p>If the AMI
     *         supports multiple versions of Hadoop (for example, AMI 1.0 supports
     *         both Hadoop 0.18 and 0.20) you can use the
     *         <a>JobFlowInstancesConfig</a> <code>HadoopVersion</code> parameter to
     *         modify the version of Hadoop from the defaults shown above. <p>For
     *         details about the AMI versions currently supported by Amazon
     *         ElasticMapReduce, go to <a
     *         perGuide/EnvironmentConfig_AMIVersion.html#ami-versions-supported">AMI
     *         Versions Supported in Elastic MapReduce</a> in the <i>Amazon Elastic
     *         MapReduce Developer's Guide.</i>
     */
    public void setAmiVersion(String amiVersion) {
        this.amiVersion = amiVersion;
    }
    
    /**
     * The version of the Amazon Machine Image (AMI) to use when launching
     * Amazon EC2 instances in the job flow. The following values are valid:
     * <ul> <li>"latest" (latest AMI version; currently AMI 2.0, Hadoop
     * 0.20.205)</li> <li>"2.0" (AMI 2.0, Hadoop 0.20.205)</li> <li>"1.0"
     * (AMI 1.0, Hadoop 0.18)</li> </ul> <p>If this value is not specified,
     * the job flow uses the default of (AMI 1.0, Hadoop 0.18). <p>If the AMI
     * supports multiple versions of Hadoop (for example, AMI 1.0 supports
     * both Hadoop 0.18 and 0.20) you can use the
     * <a>JobFlowInstancesConfig</a> <code>HadoopVersion</code> parameter to
     * modify the version of Hadoop from the defaults shown above. <p>For
     * details about the AMI versions currently supported by Amazon
     * ElasticMapReduce, go to <a
     * perGuide/EnvironmentConfig_AMIVersion.html#ami-versions-supported">AMI
     * Versions Supported in Elastic MapReduce</a> in the <i>Amazon Elastic
     * MapReduce Developer's Guide.</i>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 256<br/>
     * <b>Pattern: </b>[\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF\r\n\t]*<br/>
     *
     * @param amiVersion The version of the Amazon Machine Image (AMI) to use when launching
     *         Amazon EC2 instances in the job flow. The following values are valid:
     *         <ul> <li>"latest" (latest AMI version; currently AMI 2.0, Hadoop
     *         0.20.205)</li> <li>"2.0" (AMI 2.0, Hadoop 0.20.205)</li> <li>"1.0"
     *         (AMI 1.0, Hadoop 0.18)</li> </ul> <p>If this value is not specified,
     *         the job flow uses the default of (AMI 1.0, Hadoop 0.18). <p>If the AMI
     *         supports multiple versions of Hadoop (for example, AMI 1.0 supports
     *         both Hadoop 0.18 and 0.20) you can use the
     *         <a>JobFlowInstancesConfig</a> <code>HadoopVersion</code> parameter to
     *         modify the version of Hadoop from the defaults shown above. <p>For
     *         details about the AMI versions currently supported by Amazon
     *         ElasticMapReduce, go to <a
     *         perGuide/EnvironmentConfig_AMIVersion.html#ami-versions-supported">AMI
     *         Versions Supported in Elastic MapReduce</a> in the <i>Amazon Elastic
     *         MapReduce Developer's Guide.</i>
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withAmiVersion(String amiVersion) {
        this.amiVersion = amiVersion;
        return this;
    }
    
    
    /**
     * A specification of the number and type of Amazon EC2 instances on
     * which to run the job flow.
     *
     * @return A specification of the number and type of Amazon EC2 instances on
     *         which to run the job flow.
     */
    public JobFlowInstancesConfig getInstances() {
        return instances;
    }
    
    /**
     * A specification of the number and type of Amazon EC2 instances on
     * which to run the job flow.
     *
     * @param instances A specification of the number and type of Amazon EC2 instances on
     *         which to run the job flow.
     */
    public void setInstances(JobFlowInstancesConfig instances) {
        this.instances = instances;
    }
    
    /**
     * A specification of the number and type of Amazon EC2 instances on
     * which to run the job flow.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param instances A specification of the number and type of Amazon EC2 instances on
     *         which to run the job flow.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withInstances(JobFlowInstancesConfig instances) {
        this.instances = instances;
        return this;
    }
    
    
    /**
     * A list of steps to be executed by the job flow.
     *
     * @return A list of steps to be executed by the job flow.
     */
    public java.util.List<StepConfig> getSteps() {
        
        if (steps == null) {
            steps = new java.util.ArrayList<StepConfig>();
        }
        return steps;
    }
    
    /**
     * A list of steps to be executed by the job flow.
     *
     * @param steps A list of steps to be executed by the job flow.
     */
    public void setSteps(java.util.Collection<StepConfig> steps) {
        if (steps == null) {
            this.steps = null;
            return;
        }

        java.util.List<StepConfig> stepsCopy = new java.util.ArrayList<StepConfig>(steps.size());
        stepsCopy.addAll(steps);
        this.steps = stepsCopy;
    }
    
    /**
     * A list of steps to be executed by the job flow.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param steps A list of steps to be executed by the job flow.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withSteps(StepConfig... steps) {
        if (getSteps() == null) setSteps(new java.util.ArrayList<StepConfig>(steps.length));
        for (StepConfig value : steps) {
            getSteps().add(value);
        }
        return this;
    }
    
    /**
     * A list of steps to be executed by the job flow.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param steps A list of steps to be executed by the job flow.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withSteps(java.util.Collection<StepConfig> steps) {
        if (steps == null) {
            this.steps = null;
        } else {
            java.util.List<StepConfig> stepsCopy = new java.util.ArrayList<StepConfig>(steps.size());
            stepsCopy.addAll(steps);
            this.steps = stepsCopy;
        }

        return this;
    }
    
    /**
     * A list of bootstrap actions that will be run before Hadoop is started
     * on the cluster nodes.
     *
     * @return A list of bootstrap actions that will be run before Hadoop is started
     *         on the cluster nodes.
     */
    public java.util.List<BootstrapActionConfig> getBootstrapActions() {
        
        if (bootstrapActions == null) {
            bootstrapActions = new java.util.ArrayList<BootstrapActionConfig>();
        }
        return bootstrapActions;
    }
    
    /**
     * A list of bootstrap actions that will be run before Hadoop is started
     * on the cluster nodes.
     *
     * @param bootstrapActions A list of bootstrap actions that will be run before Hadoop is started
     *         on the cluster nodes.
     */
    public void setBootstrapActions(java.util.Collection<BootstrapActionConfig> bootstrapActions) {
        if (bootstrapActions == null) {
            this.bootstrapActions = null;
            return;
        }

        java.util.List<BootstrapActionConfig> bootstrapActionsCopy = new java.util.ArrayList<BootstrapActionConfig>(bootstrapActions.size());
        bootstrapActionsCopy.addAll(bootstrapActions);
        this.bootstrapActions = bootstrapActionsCopy;
    }
    
    /**
     * A list of bootstrap actions that will be run before Hadoop is started
     * on the cluster nodes.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param bootstrapActions A list of bootstrap actions that will be run before Hadoop is started
     *         on the cluster nodes.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withBootstrapActions(BootstrapActionConfig... bootstrapActions) {
        if (getBootstrapActions() == null) setBootstrapActions(new java.util.ArrayList<BootstrapActionConfig>(bootstrapActions.length));
        for (BootstrapActionConfig value : bootstrapActions) {
            getBootstrapActions().add(value);
        }
        return this;
    }
    
    /**
     * A list of bootstrap actions that will be run before Hadoop is started
     * on the cluster nodes.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param bootstrapActions A list of bootstrap actions that will be run before Hadoop is started
     *         on the cluster nodes.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withBootstrapActions(java.util.Collection<BootstrapActionConfig> bootstrapActions) {
        if (bootstrapActions == null) {
            this.bootstrapActions = null;
        } else {
            java.util.List<BootstrapActionConfig> bootstrapActionsCopy = new java.util.ArrayList<BootstrapActionConfig>(bootstrapActions.size());
            bootstrapActionsCopy.addAll(bootstrapActions);
            this.bootstrapActions = bootstrapActionsCopy;
        }

        return this;
    }
    
    /**
     * A list of strings that indicates third-party software to use with the
     * job flow. For more information, go to <a
     * lasticMapReduce/latest/DeveloperGuide/emr-supported-products.html">Use
     * Third Party Applications with Amazon EMR</a>. Currently supported
     * values are: <ul> <li>"karmasphere-enterprise-utility" - tag the job
     * flow for management by <a
     * ://aws.amazon.com/elasticmapreduce/karmasphere/">Karmasphere.</a></li>
     * <li>"mapr-m3" - launch the job flow using MapR M3 Edition.</li>
     * <li>"mapr-m5" - launch the job flow using MapR M5 Edition.</li> </ul>
     *
     * @return A list of strings that indicates third-party software to use with the
     *         job flow. For more information, go to <a
     *         lasticMapReduce/latest/DeveloperGuide/emr-supported-products.html">Use
     *         Third Party Applications with Amazon EMR</a>. Currently supported
     *         values are: <ul> <li>"karmasphere-enterprise-utility" - tag the job
     *         flow for management by <a
     *         ://aws.amazon.com/elasticmapreduce/karmasphere/">Karmasphere.</a></li>
     *         <li>"mapr-m3" - launch the job flow using MapR M3 Edition.</li>
     *         <li>"mapr-m5" - launch the job flow using MapR M5 Edition.</li> </ul>
     */
    public java.util.List<String> getSupportedProducts() {
        
        if (supportedProducts == null) {
            supportedProducts = new java.util.ArrayList<String>();
        }
        return supportedProducts;
    }
    
    /**
     * A list of strings that indicates third-party software to use with the
     * job flow. For more information, go to <a
     * lasticMapReduce/latest/DeveloperGuide/emr-supported-products.html">Use
     * Third Party Applications with Amazon EMR</a>. Currently supported
     * values are: <ul> <li>"karmasphere-enterprise-utility" - tag the job
     * flow for management by <a
     * ://aws.amazon.com/elasticmapreduce/karmasphere/">Karmasphere.</a></li>
     * <li>"mapr-m3" - launch the job flow using MapR M3 Edition.</li>
     * <li>"mapr-m5" - launch the job flow using MapR M5 Edition.</li> </ul>
     *
     * @param supportedProducts A list of strings that indicates third-party software to use with the
     *         job flow. For more information, go to <a
     *         lasticMapReduce/latest/DeveloperGuide/emr-supported-products.html">Use
     *         Third Party Applications with Amazon EMR</a>. Currently supported
     *         values are: <ul> <li>"karmasphere-enterprise-utility" - tag the job
     *         flow for management by <a
     *         ://aws.amazon.com/elasticmapreduce/karmasphere/">Karmasphere.</a></li>
     *         <li>"mapr-m3" - launch the job flow using MapR M3 Edition.</li>
     *         <li>"mapr-m5" - launch the job flow using MapR M5 Edition.</li> </ul>
     */
    public void setSupportedProducts(java.util.Collection<String> supportedProducts) {
        if (supportedProducts == null) {
            this.supportedProducts = null;
            return;
        }

        java.util.List<String> supportedProductsCopy = new java.util.ArrayList<String>(supportedProducts.size());
        supportedProductsCopy.addAll(supportedProducts);
        this.supportedProducts = supportedProductsCopy;
    }
    
    /**
     * A list of strings that indicates third-party software to use with the
     * job flow. For more information, go to <a
     * lasticMapReduce/latest/DeveloperGuide/emr-supported-products.html">Use
     * Third Party Applications with Amazon EMR</a>. Currently supported
     * values are: <ul> <li>"karmasphere-enterprise-utility" - tag the job
     * flow for management by <a
     * ://aws.amazon.com/elasticmapreduce/karmasphere/">Karmasphere.</a></li>
     * <li>"mapr-m3" - launch the job flow using MapR M3 Edition.</li>
     * <li>"mapr-m5" - launch the job flow using MapR M5 Edition.</li> </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param supportedProducts A list of strings that indicates third-party software to use with the
     *         job flow. For more information, go to <a
     *         lasticMapReduce/latest/DeveloperGuide/emr-supported-products.html">Use
     *         Third Party Applications with Amazon EMR</a>. Currently supported
     *         values are: <ul> <li>"karmasphere-enterprise-utility" - tag the job
     *         flow for management by <a
     *         ://aws.amazon.com/elasticmapreduce/karmasphere/">Karmasphere.</a></li>
     *         <li>"mapr-m3" - launch the job flow using MapR M3 Edition.</li>
     *         <li>"mapr-m5" - launch the job flow using MapR M5 Edition.</li> </ul>
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withSupportedProducts(String... supportedProducts) {
        if (getSupportedProducts() == null) setSupportedProducts(new java.util.ArrayList<String>(supportedProducts.length));
        for (String value : supportedProducts) {
            getSupportedProducts().add(value);
        }
        return this;
    }
    
    /**
     * A list of strings that indicates third-party software to use with the
     * job flow. For more information, go to <a
     * lasticMapReduce/latest/DeveloperGuide/emr-supported-products.html">Use
     * Third Party Applications with Amazon EMR</a>. Currently supported
     * values are: <ul> <li>"karmasphere-enterprise-utility" - tag the job
     * flow for management by <a
     * ://aws.amazon.com/elasticmapreduce/karmasphere/">Karmasphere.</a></li>
     * <li>"mapr-m3" - launch the job flow using MapR M3 Edition.</li>
     * <li>"mapr-m5" - launch the job flow using MapR M5 Edition.</li> </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param supportedProducts A list of strings that indicates third-party software to use with the
     *         job flow. For more information, go to <a
     *         lasticMapReduce/latest/DeveloperGuide/emr-supported-products.html">Use
     *         Third Party Applications with Amazon EMR</a>. Currently supported
     *         values are: <ul> <li>"karmasphere-enterprise-utility" - tag the job
     *         flow for management by <a
     *         ://aws.amazon.com/elasticmapreduce/karmasphere/">Karmasphere.</a></li>
     *         <li>"mapr-m3" - launch the job flow using MapR M3 Edition.</li>
     *         <li>"mapr-m5" - launch the job flow using MapR M5 Edition.</li> </ul>
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withSupportedProducts(java.util.Collection<String> supportedProducts) {
        if (supportedProducts == null) {
            this.supportedProducts = null;
        } else {
            java.util.List<String> supportedProductsCopy = new java.util.ArrayList<String>(supportedProducts.size());
            supportedProductsCopy.addAll(supportedProducts);
            this.supportedProducts = supportedProductsCopy;
        }

        return this;
    }
    
    /**
     * Whether the job flow is visible to all IAM users of the AWS account
     * associated with the job flow. If this value is set to
     * <code>true</code>, all IAM users of that AWS account can view and (if
     * they have the proper policy permissions set) manage the job flow. If
     * it is set to <code>false</code>, only the IAM user that created the
     * job flow can view and manage it.
     *
     * @return Whether the job flow is visible to all IAM users of the AWS account
     *         associated with the job flow. If this value is set to
     *         <code>true</code>, all IAM users of that AWS account can view and (if
     *         they have the proper policy permissions set) manage the job flow. If
     *         it is set to <code>false</code>, only the IAM user that created the
     *         job flow can view and manage it.
     */
    public Boolean isVisibleToAllUsers() {
        return visibleToAllUsers;
    }
    
    /**
     * Whether the job flow is visible to all IAM users of the AWS account
     * associated with the job flow. If this value is set to
     * <code>true</code>, all IAM users of that AWS account can view and (if
     * they have the proper policy permissions set) manage the job flow. If
     * it is set to <code>false</code>, only the IAM user that created the
     * job flow can view and manage it.
     *
     * @param visibleToAllUsers Whether the job flow is visible to all IAM users of the AWS account
     *         associated with the job flow. If this value is set to
     *         <code>true</code>, all IAM users of that AWS account can view and (if
     *         they have the proper policy permissions set) manage the job flow. If
     *         it is set to <code>false</code>, only the IAM user that created the
     *         job flow can view and manage it.
     */
    public void setVisibleToAllUsers(Boolean visibleToAllUsers) {
        this.visibleToAllUsers = visibleToAllUsers;
    }
    
    /**
     * Whether the job flow is visible to all IAM users of the AWS account
     * associated with the job flow. If this value is set to
     * <code>true</code>, all IAM users of that AWS account can view and (if
     * they have the proper policy permissions set) manage the job flow. If
     * it is set to <code>false</code>, only the IAM user that created the
     * job flow can view and manage it.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param visibleToAllUsers Whether the job flow is visible to all IAM users of the AWS account
     *         associated with the job flow. If this value is set to
     *         <code>true</code>, all IAM users of that AWS account can view and (if
     *         they have the proper policy permissions set) manage the job flow. If
     *         it is set to <code>false</code>, only the IAM user that created the
     *         job flow can view and manage it.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public RunJobFlowRequest withVisibleToAllUsers(Boolean visibleToAllUsers) {
        this.visibleToAllUsers = visibleToAllUsers;
        return this;
    }
    
    
    /**
     * Whether the job flow is visible to all IAM users of the AWS account
     * associated with the job flow. If this value is set to
     * <code>true</code>, all IAM users of that AWS account can view and (if
     * they have the proper policy permissions set) manage the job flow. If
     * it is set to <code>false</code>, only the IAM user that created the
     * job flow can view and manage it.
     *
     * @return Whether the job flow is visible to all IAM users of the AWS account
     *         associated with the job flow. If this value is set to
     *         <code>true</code>, all IAM users of that AWS account can view and (if
     *         they have the proper policy permissions set) manage the job flow. If
     *         it is set to <code>false</code>, only the IAM user that created the
     *         job flow can view and manage it.
     */
    public Boolean getVisibleToAllUsers() {
        return visibleToAllUsers;
    }
    
    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getName() != null) sb.append("Name: " + getName() + ", ");
        if (getLogUri() != null) sb.append("LogUri: " + getLogUri() + ", ");
        if (getAdditionalInfo() != null) sb.append("AdditionalInfo: " + getAdditionalInfo() + ", ");
        if (getAmiVersion() != null) sb.append("AmiVersion: " + getAmiVersion() + ", ");
        if (getInstances() != null) sb.append("Instances: " + getInstances() + ", ");
        if (getSteps() != null) sb.append("Steps: " + getSteps() + ", ");
        if (getBootstrapActions() != null) sb.append("BootstrapActions: " + getBootstrapActions() + ", ");
        if (getSupportedProducts() != null) sb.append("SupportedProducts: " + getSupportedProducts() + ", ");
        if (isVisibleToAllUsers() != null) sb.append("VisibleToAllUsers: " + isVisibleToAllUsers() + ", ");
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getName() == null) ? 0 : getName().hashCode()); 
        hashCode = prime * hashCode + ((getLogUri() == null) ? 0 : getLogUri().hashCode()); 
        hashCode = prime * hashCode + ((getAdditionalInfo() == null) ? 0 : getAdditionalInfo().hashCode()); 
        hashCode = prime * hashCode + ((getAmiVersion() == null) ? 0 : getAmiVersion().hashCode()); 
        hashCode = prime * hashCode + ((getInstances() == null) ? 0 : getInstances().hashCode()); 
        hashCode = prime * hashCode + ((getSteps() == null) ? 0 : getSteps().hashCode()); 
        hashCode = prime * hashCode + ((getBootstrapActions() == null) ? 0 : getBootstrapActions().hashCode()); 
        hashCode = prime * hashCode + ((getSupportedProducts() == null) ? 0 : getSupportedProducts().hashCode()); 
        hashCode = prime * hashCode + ((isVisibleToAllUsers() == null) ? 0 : isVisibleToAllUsers().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof RunJobFlowRequest == false) return false;
        RunJobFlowRequest other = (RunJobFlowRequest)obj;
        
        if (other.getName() == null ^ this.getName() == null) return false;
        if (other.getName() != null && other.getName().equals(this.getName()) == false) return false; 
        if (other.getLogUri() == null ^ this.getLogUri() == null) return false;
        if (other.getLogUri() != null && other.getLogUri().equals(this.getLogUri()) == false) return false; 
        if (other.getAdditionalInfo() == null ^ this.getAdditionalInfo() == null) return false;
        if (other.getAdditionalInfo() != null && other.getAdditionalInfo().equals(this.getAdditionalInfo()) == false) return false; 
        if (other.getAmiVersion() == null ^ this.getAmiVersion() == null) return false;
        if (other.getAmiVersion() != null && other.getAmiVersion().equals(this.getAmiVersion()) == false) return false; 
        if (other.getInstances() == null ^ this.getInstances() == null) return false;
        if (other.getInstances() != null && other.getInstances().equals(this.getInstances()) == false) return false; 
        if (other.getSteps() == null ^ this.getSteps() == null) return false;
        if (other.getSteps() != null && other.getSteps().equals(this.getSteps()) == false) return false; 
        if (other.getBootstrapActions() == null ^ this.getBootstrapActions() == null) return false;
        if (other.getBootstrapActions() != null && other.getBootstrapActions().equals(this.getBootstrapActions()) == false) return false; 
        if (other.getSupportedProducts() == null ^ this.getSupportedProducts() == null) return false;
        if (other.getSupportedProducts() != null && other.getSupportedProducts().equals(this.getSupportedProducts()) == false) return false; 
        if (other.isVisibleToAllUsers() == null ^ this.isVisibleToAllUsers() == null) return false;
        if (other.isVisibleToAllUsers() != null && other.isVisibleToAllUsers().equals(this.isVisibleToAllUsers()) == false) return false; 
        return true;
    }
    
}
    