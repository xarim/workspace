package clases;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class map extends TagSupport {

	    public int doEndTag() throws JspException {
	        JspWriter out = pageContext.getOut();
	        try {
	            out.println("<iframe width=\"425\" height=\"550\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" src=\"http://maps.google.es/maps?f=q&amp;source=s_q&amp;hl=es&amp;geocode=&amp;q=castillejos+288,+barcelona&amp;aq=&amp;sll=40.396764,-3.713379&amp;sspn=9.651041,19.753418&amp;ie=UTF8&amp;hq=&amp;hnear=Carrer+de+los+Castillejos,+288,+08025+Barcelona,+Catalunya&amp;ll=41.407695,2.17679&amp;spn=0.009286,0.01929&amp;t=m&amp;z=14&amp;iwloc=A&amp;output=embed\"></iframe><br /><small><a href=\"http://maps.google.es/maps?f=q&amp;source=embed&amp;hl=es&amp;geocode=&amp;q=castillejos+288,+barcelona&amp;aq=&amp;sll=40.396764,-3.713379&amp;sspn=9.651041,19.753418&amp;ie=UTF8&amp;hq=&amp;hnear=Carrer+de+los+Castillejos,+288,+08025+Barcelona,+Catalunya&amp;ll=41.407695,2.17679&amp;spn=0.009286,0.01929&amp;t=m&amp;z=14&amp;iwloc=A\" style=\"color:#0000FF;text-align:left\">Ver mapa más grande</a></small>");
	        }
	        catch (Exception e) {
	        }
	        return super.doEndTag();
	    }
}
