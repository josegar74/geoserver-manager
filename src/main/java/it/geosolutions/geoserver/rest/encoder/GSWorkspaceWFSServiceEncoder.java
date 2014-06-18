package it.geosolutions.geoserver.rest.encoder;

import it.geosolutions.geoserver.rest.encoder.utils.ElementUtils;
import it.geosolutions.geoserver.rest.encoder.utils.PropertyXMLEncoder;
import org.jdom.Element;

/**
 * Workspace WFS service encoder.
 *
 * @author Jose García (josegar74@gmail.com)
 *
 * @since gs-2.2.1
 */
public class GSWorkspaceWFSServiceEncoder extends PropertyXMLEncoder {
    public final static String WFS = "wfs";
    private final static String TITLE = "title";
    private final static String MAINTAINER = "maintainer";
    private final static String ABSTRCT = "abstrct";
    private final static String ACCESS_CONSTRAINTS = "accessConstraints";
    private final static String FEES = "fees";
    private final static String SERVICE_LEVEL = "serviceLevel";
    private final static String MAX_FEATURES = "maxFeatures";
    private final static String FEATURE_BOUNDING = "featureBounding";
    private final static String CANONICAL_SCHEMA_LOCATION = "canonicalSchemaLocation";
    private final static String ENCODE_FEATURE_MEMBER = "encodeFeatureMember";
    private final static String HITS_IGNORE_MAX_FEATURES = "hitsIgnoreMaxFeatures";
    private final static String ONLINE_RESOURCE = "onlineResource";
    private final static String CITE_COMPLIANT = "citeCompliant";
    private final static String VERBOSE = "verbose";
    private final static String SCHEMA_BASE_URL = "schemaBaseURL";


    private String workspace;

    public GSWorkspaceWFSServiceEncoder(String workspace) {
        super(WFS);

        this.workspace = workspace;

        Element workspaceElem = elem("workspace", elem("name", workspace));
        addContent(workspaceElem);

        add("enabled", "true");
        add("name", "WFS");

        Element versionsElem = elem("versions",
                elem("org.geotools.util.Version", elem("version", "1.0.0")),
                elem("org.geotools.util.Version", elem("version", "1.1.0")),
                elem("org.geotools.util.Version", elem("version", "2.0.0")));

        addContent(versionsElem);

        add(CITE_COMPLIANT, "false");
        add(SCHEMA_BASE_URL, "http://schemas.opengis.net");
        add(VERBOSE, "false");

        // TODO: Allow customise gml values
        Element gmlElem = elem("gml",
                elem("entry",
                        elem("version", "V_11"),
                        elem("gml", elem("srsNameStyle", "URN"), elem("overrideGMLAttributes", "false"))),
                elem("entry",
                        elem("version", "V_10"),
                        elem("gml", elem("srsNameStyle", "XML"), elem("overrideGMLAttributes", "true"))),
                elem("entry",
                        elem("version", "V_20"),
                        elem("gml", elem("srsNameStyle", "URN2"), elem("overrideGMLAttributes", "false"))));

        addContent(gmlElem);


        add(SERVICE_LEVEL, "COMPLETE");
        add(MAX_FEATURES, "1000000");
        add(FEATURE_BOUNDING, "true");
        add(CANONICAL_SCHEMA_LOCATION, "false");
        add(ENCODE_FEATURE_MEMBER, "false");
        add(HITS_IGNORE_MAX_FEATURES, "false");

        add(TITLE, "");
        add(MAINTAINER, "");
        add(ABSTRCT, "");
        add(ACCESS_CONSTRAINTS, "");
        add(FEES, "");
        add(ONLINE_RESOURCE, "");
    }

    public void setTitle(String title){
        set(TITLE, title);
    }

    public void setMaintainer(String maintainer){
        set(MAINTAINER, maintainer);
    }

    public void setAbstrct(String abstrct){
        set(ABSTRCT, abstrct);
    }

    public void setAccessConstraints(String accessConstraints){
        set(ACCESS_CONSTRAINTS, accessConstraints);
    }

    public void setFees(String fees){
        set(FEES, fees);
    }

    public void setOnlineResource(String onlineResource){
        set(ONLINE_RESOURCE, onlineResource);
    }

    public void setServiceLevel(String serviceLevel){
        set(SERVICE_LEVEL, serviceLevel);
    }

    public void setMaxFeatures(int maxFeatures){
        set(MAX_FEATURES, maxFeatures+"");
    }

    public void setFeatureBounding(boolean featureBounding){
        set(FEATURE_BOUNDING, Boolean.toString(featureBounding));
    }

    public void setCanonicalSchemaLocation(boolean canonicalSchemaLocation){
        set(CANONICAL_SCHEMA_LOCATION, Boolean.toString(canonicalSchemaLocation));
    }

    public void setEncodeFeatureMember(boolean encodeFeatureMember){
        set(ENCODE_FEATURE_MEMBER, Boolean.toString(encodeFeatureMember));
    }

    public void setHitsIgnoreMaxFeatures(boolean hitsIgnoreMaxFeatures){
        set(HITS_IGNORE_MAX_FEATURES, Boolean.toString(hitsIgnoreMaxFeatures));
    }

    public void setCiteCompliant(boolean citeCompliant){
        set(CITE_COMPLIANT, Boolean.toString(citeCompliant));
    }

    public void setSchemaBaseUrl(String schemaBaseUrl){
        set(SCHEMA_BASE_URL, schemaBaseUrl);
    }

    public void setVerbose(boolean verbose){
        set(VERBOSE, Boolean.toString(verbose));
    }

    public String getWorkspace() {
        return  workspace;
    }

    public String getTitle(){
        return getElemValue(TITLE);
    }

    public String getMaintainer(){
        return getElemValue(MAINTAINER);
    }

    public String getAbstrct(){
        return getElemValue(ABSTRCT);
    }

    public String getAccessConstraints(){
        return getElemValue(ACCESS_CONSTRAINTS);
    }

    public String getFees(){
        return getElemValue(FEES);
    }

    public String getOnlineResource(){
        return getElemValue(ONLINE_RESOURCE);
    }

    public String getServiceLevel(){
        return getElemValue(SERVICE_LEVEL);
    }

    public String getSchemaBaseUrl(){
        return getElemValue(SCHEMA_BASE_URL);
    }

    public boolean getCiteCompliant(){
        String val = getElemValue(CITE_COMPLIANT);

        return (val!=null)?Boolean.parseBoolean(val):false;
    }

    public boolean getVerbose(){
        String val = getElemValue(VERBOSE);

        return (val!=null)?Boolean.parseBoolean(val):false;
    }

    public boolean getFeatureBounding(){
        String val = getElemValue(FEATURE_BOUNDING);

        return (val!=null)?Boolean.parseBoolean(val):false;
    }

    public boolean getCanonicalSchemaLocation(){
        String val = getElemValue(CANONICAL_SCHEMA_LOCATION);

        return (val!=null)?Boolean.parseBoolean(val):false;
    }

    public boolean getEncodeFeatureMember(){
        String val = getElemValue(ENCODE_FEATURE_MEMBER);

        return (val!=null)?Boolean.parseBoolean(val):false;
    }

    public boolean getHitsIgnoreMaxFeatures(){
        String val = getElemValue(HITS_IGNORE_MAX_FEATURES);

        return (val!=null)?Boolean.parseBoolean(val):false;
    }

    public int getMaxFeatures() {
        String val = getElemValue(MAX_FEATURES);

        return (val!=null)?Integer.parseInt(val):0;
    }
}