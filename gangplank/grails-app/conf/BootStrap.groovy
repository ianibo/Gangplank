import gangplank.*

class BootStrap {

  def init = { servletContext ->

    RefdataCategory.lookupOrCreate('DatafileStatus', 'Pending Compliance Review')
    RefdataCategory.lookupOrCreate('DatafileStatus', 'Publication Denied')
    RefdataCategory.lookupOrCreate('DatafileStatus', 'Published')

    RefdataCategory.lookupOrCreate('Category', 'Adult Social Services')
    RefdataCategory.lookupOrCreate('Category', 'Children, Young People and Education')
    RefdataCategory.lookupOrCreate('Category', 'Council Information')
    RefdataCategory.lookupOrCreate('Category', 'Democracy')
    RefdataCategory.lookupOrCreate('Category', 'Employees')
    RefdataCategory.lookupOrCreate('Category', 'Environment')
    RefdataCategory.lookupOrCreate('Category', 'Finance')
    RefdataCategory.lookupOrCreate('Category', 'Housing')
    RefdataCategory.lookupOrCreate('Category', 'Planning and Land')
    RefdataCategory.lookupOrCreate('Category', 'Property')

    def expenses_props = [ [ label:'Name', propname:'name'], 
                           [ label:'Cost Centre', propname:'costcentre'], 
                           [ label:'Amount', propname:'amount'] ]

    // Just some silly test data
    // Wonder if there is a taxonomy of these classes
    def expenses_schema = Schema.findByName('Finance.Expenses');
    if ( expenses_schema == null ) {
      expenses_schema = new Schema(name:'Finance.Expenses').save();
    }

    expenses_props.each { propdef ->
      def dbprop = Property.findBySchemaAndName(expenses_schema, propdef.propname)
      if ( dbprop == null ) {
        dbprop = new Property(
                              schema:expenses_schema, 
                              name:propdef.propname, 
                              label:propdef.label, 
                              mandatory:true).save();
      }
    }

    
  }

  def destroy = {
  }
}
