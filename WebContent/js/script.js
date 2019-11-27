function validateMenuItem()
{
                
                var title=document.forms["editMenuForm"]["mname"].value;
                var price=document.forms["editMenuForm"]["price"].value;
                var dol=document.forms["editMenuForm"]["launch"].value;
                var cate=document.forms["editMenuForm"]["category"].value;
                
                if(title== "")
                { 
                alert("Title is required");
                return false;
                }
               else if(title.length<2 || title.length>65)
                {
                alert("Tile should have 2 to 65 characters");
                return false;
                }
                 if(price == "")
                {
                alert("Gross is required"); 
                return false;
                }
                else if(isNaN(price))
                {
                alert("Gross has to be number");
                return false;
                }
                if(dol == "")
                {
                alert("Date of launch is empty");
                return false;
                }
                 if(cate == "empty")
                {
                alert("Genre is empty");
                return false;
                }
                
}