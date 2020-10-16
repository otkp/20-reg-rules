var tax;
var tax_Quarterly=0;
var tax_Penalty=0;
var tax_Arrears=0;
var tax_PenaltyArrears=0;
var tax_Advance=0;
var percent_Tax=0;
var percent_Arrears=0;
var tax_Total=0;
var tax_Current=0;
var stoppages=0;
var response=[];
var sameQuarter=false;
var tax_ServiceCharge=0;
var total_Amount=0;

/*Default Configurations*/
// tax type Q=Quarterly,H=halfyearly,Y=yearly
var tax_Type = {
		"Q" : 0,"H" : 1,"Y" : 3
};
																			
// service charges
var tax_ServiceCharges ={
		//service charges for tax below 500=10
		//service charges for tax above 500=20
		"serviceCharge_1":10 ,"serviceCharge_2":20		
};

// tax calculation in voluntary mode
var voluntary_Mode = {
		"M1" : [{percent_Tax:0},{percent_Arrears:50},{totalmonths:3}],
		"M2" : [{percent_Tax:25},{percent_Arrears:50},{totalmonths:2}],
		"M3" : [{percent_Tax:50},{percent_Arrears:50},{totalmonths:1}]
};
// tax calculation in detection mode
var detection_Mode = {
		"M1" : [{percent_Tax:0},{percent_Arrears:200},{totalmonths:3}],
		"M2" : [{percent_Tax:100},{percent_Arrears:200},{totalmonths:2}],
		"M3" : [{percent_Tax:200},{percent_Arrears:200},{totalmonths:1}]
};
/*Default Configurations*/

// tax calculation for registered vehicles
var taxCal_Registered=function(_inputData)
{
	//Quarterly tax amount
	tax_Quarterly=_inputData["tax"];
	//tax for half yearly,yearly
	tax_Advance=0;
	try{
		tax_Advance = parseInt(tax_Type[_inputData["tax_Type"]])*_inputData["tax"];
	}catch(e){

	}
	
	// voluntary Mode
	if(_inputData["vcr_BookedDate"]==null||_inputData["vcr_BookedDate"]<_inputData["tax_Validity"])
	{
		print("vcrbooked is smaller");
		percent_Tax=voluntary_Mode[_inputData["month"]][0].percent_Tax;
		percent_Arrears=voluntary_Mode[_inputData["month"]][1].percent_Arrears;	
	}
	
	// Detection Mode
	else {
		print("vcr booked is greater")
		percent_Tax=detection_Mode[_inputData["month"]][0].percent_Tax;
		percent_Arrears=detection_Mode[_inputData["month"]][1].percent_Arrears;	
	}	
	
	// if vehicle is not seized
	if(_inputData["seized"]==false) {
		if(_inputData["stoppages"]=="no")
		{
			tax_Current=((tax_Quarterly)*((3-stoppages)/3));
		}
		else {
			tax_Current=Math.max(0,((tax_Quarterly)*((voluntary_Mode[_inputData["month"]][2].totalmonths-_inputData["stoppages"])/3)));
		}
		tax_Total=tax_Current+tax_Advance;
		print("tax_Current"+tax_Current+"tax_Total"+tax_Total);
		tax_Penalty=((tax_Current*percent_Tax)/100);	
		print("penality"+tax_Penalty);
		tax_Arrears=Math.max(0,(_inputData["tax_PendingQuarters"]*_inputData["tax"]));
		tax_PenaltyArrears=((tax_Arrears*percent_Arrears)/100);
		print("tax arrears"+tax_Arrears+"penalityArrears"+tax_PenaltyArrears);
	}

	// if vehicle is seized
	else if(_inputData["seized"]==true)
	{
		// vcr issued and payment date comes in same quarter
		if(_inputData["sameQuarter"]==true){
			//if no stoppages 
			if(_inputData["stoppages"]=="no") {
				tax_Current=(tax_Quarterly*(3-_inputData["monthsdiff"]))/3;
			}
			//stoppages 
			else
			{
				tax_Current=Math.max(0,(tax_Quarterly*((voluntary_Mode[_inputData["month"]][2].totalmonths-_inputData["monthsdiff"]-_inputData["stoppages"])/3)));
			}
			tax_Arrears=Math.max(0,(_inputData["tax"]*_inputData["QuartersPending_ValidityToVcr"]));
			"QuartersPending_ValidityToVcr"
		}
// payment in next quarters
		else{

			if(_inputData["stoppages"]=="no")
			{
				tax_Current=((tax_Quarterly)*((voluntary_Mode[_inputData["month"]][2].totalmonths-stoppages)/3));
			}
			else {
				tax_Current=Math.max(0,((tax_Quarterly)*((voluntary_Mode[_inputData["month"]][2].totalmonths-_inputData["stoppages"])/3)));
			}
			tax_Arrears=Math.max(0,((_inputData["tax"]*_inputData["tax_PendingMonths"])/3));
		}
		tax_Total=tax_Current+tax_Advance;
		print("tax_Current"+tax_Current+"tax_Total"+tax_Total);
		tax_Penalty=((tax_Current*percent_Tax)/100);
		print("penality"+tax_Penalty);

		tax_PenaltyArrears=((tax_Arrears*percent_Arrears)/100);
		print("tax arrears"+tax_Arrears+"penalityArrears"+tax_PenaltyArrears);
	}

	// service charge for tax below 500
	if(Math.ceil(tax_Total)>0 && Math.ceil(tax_Total)<=500 )
	{
		tax_ServiceCharge=tax_ServiceCharges["serviceCharge_1"];
	}
	//service charge for tax above 500 
	else if(Math.ceil(tax_Total)>500)
	{
		tax_ServiceCharge=tax_ServiceCharges["serviceCharge_2"];
	}
// total tax amount
	tax_Amount=(Math.ceil(tax_Total/10)*10)+(Math.ceil(tax_Penalty/10)*10)+(Math.ceil(tax_Arrears/10)*10)+(Math.ceil(tax_PenaltyArrears/10)*10)+tax_ServiceCharge;
	var map_Response = new java.util.HashMap();
	map_Response.put("tax_Total",Math.ceil(tax_Total/10)*10);
	map_Response.put("tax_Penalty",Math.ceil(tax_Penalty/10)*10);
	map_Response.put("tax_Arrears",Math.ceil(tax_Arrears/10)*10);
	map_Response.put("tax_PenaltyArrears",Math.ceil(tax_PenaltyArrears/10)*10);
	map_Response.put("serviceCharges",tax_ServiceCharge);
	map_Response.put("tax_Amount",tax_Amount);
	return map_Response; 
};
// tax calculation for unregistered vehicles

var taxCal_Unregistered=function(_inputData)
{
	tax_Quarterly=_inputData["tax"];
	tax_Advance=0;
	try{
		tax_Advance = parseInt(tax_Type[_inputData["tax_Type"]])*_inputData["tax"];
	}catch(e){

	}
	tax_Current=(tax_Quarterly*voluntary_Mode[_inputData["month"]][2].totalmonths)/3;
	tax_Total=tax_Current+tax_Advance;
	var map_Response = new java.util.HashMap();
	map_Response.put("tax_Total",Math.ceil(tax_Total/10)*10);
	return map_Response;
};
