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
        set("charset",charset);
    }

    public void setNumDecimals(int numDecimals){
        set("numDecimals",numDecimals+"");
    }

    public void setVerbose(boolean verbose){
        set("verbose",Boolean.toString(verbose));
    }

    public void setVerboseExceptions(boolean verboseExceptions){
        set("verboseExceptions",Boolean.toString(verboseExceptions));
    }

    public void setLocalWorkspaceIncludesPrefix(boolean localWorkspaceIncludesPrefix){
        set("localWorkspaceIncludesPrefix",Boolean.toString(localWorkspaceIncludesPrefix));
    }

    public String getWorkspace() {
        return  workspace;
    }

    public String getCharset(){
        final Element el = ElementUtils.contains(getRoot(), CHARSET);
        if (el != null)
        {
            return el.getTextTrim();
        }
        else
        {
            return null;
        }
    }

    public int getNumDecimals(){
        final Element el = ElementUtils.contains(getRoot(), NUM_DECIMALS);
        if (el != null)
        {
            return Integer.parseInt(el.getTextTrim());
        }
        else
        {
            return 0;
        }
    }

    public boolean getVerbose(boolean verbose){
        final Element el = ElementUtils.contains(getRoot(), VERBOSE);
        if (el != null)
        {
            return Boolean.parseBoolean(el.getTextTrim());
        }
        else
        {
            return false;
        }
    }

    public boolean getVerboseExceptions(boolean verboseExceptions){
        final Element el = ElementUtils.contains(getRoot(), VERBOSE_EXCEPTIONS);
        if (el != null)
        {
            return Boolean.parseBoolean(el.getTextTrim());
        }
        else
        {
            return false;
        }
    }

    public boolean getLocalWorkspaceIncludesPrefix(boolean localWorkspaceIncludesPrefix){
        final Element el = ElementUtils.contains(getRoot(), LOCAL_WORKSPACE_INCLUDES_PREFIX);
        if (el != null)
        {
            return Boolean.parseBoolean(el.getTextTrim());
        }
        else
        {
            return false;
        }
    }



}
