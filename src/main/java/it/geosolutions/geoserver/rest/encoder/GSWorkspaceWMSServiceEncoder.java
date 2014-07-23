package it.geosolutions.geoserver.rest.encoder;

import it.geosolutions.geoserver.rest.encoder.utils.ElementUtils;
import it.geosolutions.geoserver.rest.encoder.utils.PropertyXMLEncoder;

import org.jdom.Element;

/**
 * Workspace WMS service encoder.
 *
 * @author Jose García (josegar74@gmail.com)
 *
 * @since gs-2.2.1
 */
public class GSWorkspaceWMSServiceEncoder extends PropertyXMLEncoder {
    public final static String WMS = "wms";
    private final static String TITLE = "title";
    private final static String MAINTAINER = "maintainer";
    private final static String ABSTRCT = "abstrct";
    private final static String ACCESS_CONSTRAINTS = "accessConstraints";
    private final static String FEES = "fees";
    private final static String CITE_COMPLIANT = "citeCompliant";
    private final static String VERBOSE = "verbose";
    private final static String SCHEMA_BASE_URL = "schemaBaseURL";
    private final static String BBOX_FOR_EACH_CRS = "bboxForEachCRS";
    private final static String INTERPOLATION = "interpolation";
    private final static String MAX_BUFFER = "maxBuffer";
    private final static String MAX_REQUEST_MEMORY = "maxRequestMemory";
    private final static String MAX_RENDERING_TIME = "maxRenderingTime";
    private final static String MAX_RENDERING_ERRORS = "maxRenderingErrors";

    private String workspace;
    private Element keywords;
    private Element srs;

    public GSWorkspaceWMSServiceEncoder(String workspace) {
        super(WMS);

        this.workspace = workspace;

        Element workspaceElem = elem("workspace", elem("name", workspace));
        addContent(workspaceElem);

        add("enabled", "true");
        add("name", "WMS");

        Element versionsElem = elem("versions",
                elem("org.geotools.util.Version", elem("version", "1.1.1")),
                elem("org.geotools.util.Version", elem("version", "1.3.0")));

        addContent(versionsElem);

        add(CITE_COMPLIANT, "false");
        add(SCHEMA_BASE_URL, "http://schemas.opengis.net");
        add(VERBOSE, "false");
        add(BBOX_FOR_EACH_CRS, "false");

        // TODO: Allow customise watermark
        Element watermarkElem = elem("watermark",
                elem("enabled", "false"),
                elem("position", "BOT_RIGHT"),
                elem("transparency", "100"));

        addContent(watermarkElem);

        keywords = elem("keywords");
        addContent(keywords);
        
        srs = elem("srs");
        addContent(srs);

        add(INTERPOLATION, "Nearest");
        add(MAX_BUFFER, "0");
        add(MAX_REQUEST_MEMORY, "0");
        add(MAX_RENDERING_TIME, "0");
        add(MAX_RENDERING_ERRORS, "0");

        add(TITLE, "");
        add(MAINTAINER, "");
        add(ABSTRCT, "");
        add(ACCESS_CONSTRAINTS, "");
        add(FEES, "");
    }

    /**
     * Example of usage: addKeyword("water", "en")
     * @param keyword
     * @param isolanguage
     */
    public void addKeyword(String keyword, String isolanguage) {
    	keywords.addContent(elem("string", keyword + "\\@language=" + isolanguage + "\\;"));
    }
    
    /**
     * Example of usage: addSRS("4326")
     * @param srs
     */
    public void addSRS(String srs) {
    	this.srs.addContent(elem("string", srs));
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

    public void setCiteCompliant(boolean citeCompliant){
        set(CITE_COMPLIANT, Boolean.toString(citeCompliant));
    }

    public void setSchemaBaseUrl(String schemaBaseUrl){
        set(SCHEMA_BASE_URL, schemaBaseUrl);
    }

    public void setVerbose(boolean verbose){
        set(VERBOSE, Boolean.toString(verbose));
    }

    public void setBboxForEachCRS(boolean bboxForEachCRS){
        set(VERBOSE, Boolean.toString(bboxForEachCRS));
    }

    public void setInterpolation(String interpolation){
        set(INTERPOLATION, interpolation);
    }

    public void setMaxBuffer(int maxBuffer){
        set(MAX_BUFFER, maxBuffer+"");
    }

    public void setMaxRequestMemory(int maxRequestMemory){
        set(MAX_REQUEST_MEMORY, maxRequestMemory+"");
    }

    public void setMaxRenderingTime(int maxRenderingTime){
        set(MAX_RENDERING_TIME, maxRenderingTime+"");
    }

    public void setMaxRenderingErrors(int maxRenderingErrors){
        set(MAX_RENDERING_ERRORS, maxRenderingErrors+"");
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

    public boolean getBboxForEachCRS(){
        String val = getElemValue(BBOX_FOR_EACH_CRS);

        return (val!=null)?Boolean.parseBoolean(val):false;
    }

    public int getMaxBuffer() {
        String val = getElemValue(MAX_BUFFER);

        return (val!=null)?Integer.parseInt(val):0;
    }

    public int getMaxRequestMemory() {
        String val = getElemValue(MAX_REQUEST_MEMORY);

        return (val!=null)?Integer.parseInt(val):0;
    }

    public int getMaxRenderingTime() {
        String val = getElemValue(MAX_RENDERING_TIME);

        return (val!=null)?Integer.parseInt(val):0;
    }

    public int getMaxRenderingErrors() {
        String val = getElemValue(MAX_RENDERING_ERRORS);

        return (val!=null)?Integer.parseInt(val):0;
    }
}