package stacks;

/**
 * Class Navigator provides the navigation feature of class BrowserNavigation.
 * @author CS1C, Foothill College, Michael Bernal
 * @version 1.0
 */
public class Navigator
{
    /**
     * class attributes
     */
    String currentLink;
    StackList<String> backLinks;
    StackList<String> forwardLinks;
    boolean beginStr = true;

    /**
     * A constructor that initializes the class attributes.
     */
    Navigator()
    {
        currentLink = "";
        backLinks = new StackList<String>();
        forwardLinks = new StackList<String>();
    }

    /**
     * A method called setCurrentLink() which takes an object of type String for the current requested link
     * @param currentLink current requested link
     */
    public void setCurrentLink(String currentLink)
    {
        if(beginStr)
        {
            this.currentLink = currentLink;
            beginStr = false;
        }
        else
        {
              backLinks.push(this.currentLink);
              this.currentLink = currentLink;
              forwardLinks.clear();
        }
    }

    /**
     * goBack() updates the currentLink to the link at the top of the backLinks stack
     */
    public void goBack()
    {
        if(!backLinks.isEmpty())
        {
            forwardLinks.push(currentLink);
            this.currentLink = backLinks.pop();
        }
        else
        {
                System.out.println("Empty List");
        }
    }

    /**
     * goForward() updates the currentLink to the link at the top of the forwardLinks stack
     */
    public void goForward()
    {
        if(!forwardLinks.isEmpty())
        {
            backLinks.push(currentLink);
            this.currentLink = forwardLinks.pop();
        }
        else
        {
            System.out.println("Empty List");
        }
    }

    /**
     * Accessor methods for the class attributes.
     * @return currentLink, backLinks, and forwardLinks
     */
    public String getCurrentLink() {
        return currentLink;
    }

    public StackList<String> getBackLinks() {
        return backLinks;
    }

    public StackList<String> getForwardLinks() {
        return forwardLinks;
    }
}
