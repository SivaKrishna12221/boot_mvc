<%@ page isELIgnored="false"%><br><br>
<h1 style="color:green;text-align:center">welcome to nareshit</h1>
<p>Tiles concepts
Tiles is an implementation of the Composite View pattern. Tiles adds to this pattern its own concepts to make the pattern concrete. The implementation of Tiles around the Composite View pattern consists of the Template, Attribute and Definition concepts. The View Helper pattern is implemented by the View Preparer concept.

Template
In Tiles, a template is the layout part of a page. You can see as a page structure with some gaps, called attributes, to be filled.

For instance, consider the "classic layout" page structure.

The "classic layout", a typical structure of a web page.
You can replicate this structure by creating a JSP page, as you can see below.


Notice that a template can have no attributes: in this case it can be used directly.

Attribute
An attribute is a gap in a template that needs to be filled in your application. An attribute can be of three types:

string: it is a string to be directly rendered as it is.
template: it is a template, with or without attributes. If it has attributes, you have to fill them too to render a page.
definition: it is a reusable composed page, with all (or some) attributes filled (see below).
Definition
A definition is a composition to be rendered to the end user; essentially a definition is composed of a template and completely or partially filled attributes.

If all of its attributes are filled, it can be rendered to the end user.
If not all of its attributes are filled, it is called an abstract definition, and it can be used as a base definition for extended definitions, or their missing attributes can be filled at runtime.
For example, you can create a page using the classic layout as seen before, by modifying the Tiles configuration file.


View Preparer
Sometimes a definition, before it is rendered, needs to be "prepared". For example when showing a menu, the menu structure must be created and stored in the request scope.

For this reason, a View Preparer can be used: it is called before the definition is rendered, so all the things needed to render correctly the definition can be prepared.

See the Tiles View Preparer configuration for more information. </p>
