package it.geosolutions.geoserver.rest.encoder;

import it.geosolutions.geoserver.rest.encoder.utils.ElementUtils;
import it.geosolutions.geoserver.rest.encoder.utils.PropertyXMLEncoder;
import org.jdom.Element;

/**
 * Workspace settings encoder.
 *
 * @author Jose García (josegar74@gmail.com)
 *
 * @since gs-2.2.1
 */
public class GSWorkspaceSettingsEncoder extends PropertyXMLEncoder {
    public final static String SETTINGS = "settings";
    private final static String CHARSET = "charset";
    private final static String NUM_DECIMALS = "numDecimals";
    private final static String VERBOSE = "verbose";
    private final static String VERBOSE_EXCEPTIONS = "verboseExceptions";
    private final static String LOCAL_WORKSPACE_INCLUDES_PREFIX = "localWorkspaceIncludesPrefix";

    private String workspace;

    public GSWorkspaceSettingsEncoder(String workspace) {
        super(SETTINGS);

        this.workspace = workspace;

        Element workspaceElem = elem("workspace", elem("name", workspace));
        addContent(workspaceElem);

        // TODO: Add more contact fields
        Element contactElem = elem("contact", elem("id", "contact"));
        addContent(contactElem);

        add(CHARSET, "UTF-8");
        add(NUM_DECIMALS, "4");
        add(VERBOSE, "true");
        add(VERBOSE_EXCEPTIONS, "false");
        add(LOCAL_WORKSPACE_INCLUDES_PREFIX, "false");
    }

    public void setCharset(String charset){
        set(CHARSET,charset);
    }

    public void setNumDecimals(int numDecimals){
        set(NUM_DECIMALS,numDecimals+"");
    }

    public void setVerbose(boolean verbose){
        set(VERBOSE,Boolean.toString(verbose));
    }

    public void setVerboseExceptions(boolean verboseExceptions){
        set(VERBOSE_EXCEPTIONS,Boolean.toString(verboseExceptions));
    }

    public void setLocalWorkspaceIncludesPrefix(boolean localWorkspaceIncludesPrefix){
        set("localWorkspaceIncludesPrefix",Boolean.toString(localWorkspaceIncludesPrefix));
    }

    public String getWorkspace() {
        return  workspace;
    }

    public String getCharset(){
        return getElemValue(CHARSET);
    }

    public int getNumDecimals(){
        String val = getElemValue(NUM_DECIMALS);

        return (val!=null)?Integer.parseInt(val):0;
    }

    public boolean getVerbose(){
        String val = getElemValue(VERBOSE);

        return (val!=null)?Boolean.parseBoolean(val):false;
    }

    public boolean getVerboseExceptions(){
        String val = getElemValue(VERBOSE_EXCEPTIONS);

        return (val!=null)?Boolean.parseBoolean(val):false;
    }

    public boolean getLocalWorkspaceIncludesPrefix(){
        String val = getElemValue(LOCAL_WORKSPACE_INCLUDES_PREFIX);

        return (val!=null)?Boolean.parseBoolean(val):false;
    }
}