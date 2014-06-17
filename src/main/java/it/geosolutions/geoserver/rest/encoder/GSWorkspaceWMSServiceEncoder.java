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

    private String workspace;

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

        add("citeCompliant", "false");
        add("schemaBaseURL", "http://schemas.opengis.net");
        add("verbose", "false");
        add("bboxForEachCRS", "false");

        Element watermarkElem = elem("watermark",
                elem("enabled", "false"),
                elem("position", "BOT_RIGHT"),
                elem("transparency", "100"));

        addContent(watermarkElem);

        add("interpolation", "Nearest");
        add("maxBuffer", "0");
        add("maxRequestMemory", "0");
        add("maxRenderingTime", "0");
        add("maxRenderingErrors", "0");

        add(TITLE, "");
        add(MAINTAINER, "");
        add(ABSTRCT, "");
        add(ACCESS_CONSTRAINTS, "");
        add(FEES, "");
    }

    public void setTitle(String title){
        set("title", title);
    }

    public void setMaintainer(String maintainer){
        set("maintainer", maintainer);
    }

    public void setAbstrct(String abstrct){
        set("abstrct", abstrct);
    }

    public void setAccessConstraints(String accessConstraints){
        set("accessConstraints", accessConstraints);
    }

    public void setFees(String fees){
        set("fees", fees);
    }

    public String getWorkspace() {
        return  workspace;
    }

    public String getTitle(){
        final Element el = ElementUtils.contains(getRoot(), TITLE);
        if (el != null)
        {
            return el.getTextTrim();
        }
        else
        {
            return null;
        }
    }

    public String getMaintainer(){
        final Element el = ElementUtils.contains(getRoot(), MAINTAINER);
        if (el != null)
        {
            return el.getTextTrim();
        }
        else
        {
            return null;
        }
    }

    public String getAbstrct(){
        final Element el = ElementUtils.contains(getRoot(), ABSTRCT);
        if (el != null)
        {
            return el.getTextTrim();
        }
        else
        {
            return null;
        }
    }

    public String getAccessConstraints(){
        final Element el = ElementUtils.contains(getRoot(), ACCESS_CONSTRAINTS);
        if (el != null)
        {
            return el.getTextTrim();
        }
        else
        {
            return null;
        }
    }

    public String getFees(){
        final Element el = ElementUtils.contains(getRoot(), FEES);
        if (el != null)
        {
            return el.getTextTrim();
        }
        else
        {
            return null;
        }
    }
}
