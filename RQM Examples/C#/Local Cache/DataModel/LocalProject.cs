//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace LocalCache.DataModel
{
    using System;
    using System.Collections.Generic;
    
    public partial class LocalProject
    {
    	public LocalProject()
    	{
    		this.Testcases = new HashSet<LocalTestcase>();
    		this.Testscripts = new HashSet<LocalTestscript>();
    	}
    
    	public int ID { get; set; }
    	public string Name { get; set; }
    	public string APIName { get; set; }
    	public string ServerURL { get; set; }
    	public string ServerID { get; set; }
    
    	public virtual ICollection<LocalTestcase> Testcases { get; set; }
    	public virtual ICollection<LocalTestscript> Testscripts { get; set; }
    }
}
