package com.neu.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.neu.web.dao.DrugDAO;
import com.neu.web.dao.PatientDAO;
import com.neu.web.dao.UserDAO;
import com.neu.web.pojo.Drug;
import com.neu.web.pojo.Patient;
import com.neu.web.pojo.PdfReport;
import com.neu.web.pojo.User;

@Controller
public class DoctorController {

	@Autowired
	PatientDAO patientDao;
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	DrugDAO drugDao;
	
	@RequestMapping(value = "/searchPatient.htm", method = RequestMethod.POST)
	public ModelAndView signUp(HttpServletRequest request,HttpSession session) throws Exception{
		User tempuser = (User)session.getAttribute("user");
		if(tempuser == null)
			System.out.println("logout user trying");
		
		ModelAndView mv = new ModelAndView();
		System.out.println(request.getParameter("pname"));
		List<Patient> plist = patientDao.getAllPatient(request.getParameter("pname"));
		mv.addObject("patients", plist);
		System.out.println(plist);
		if (plist.isEmpty())
			System.out.println("The returned list is empty");
		for (Patient patient : plist) {
			System.out.println("The matching patient are : " + patient.getPatientName());
		}
				
		mv.setViewName("doctor");

		return mv;		
	}
	
	@RequestMapping(value = "/finalPatient.htm", method = RequestMethod.POST)
	protected ModelAndView addPatient(HttpServletRequest request,HttpSession session) throws Exception {

		try {
			
			ModelAndView mv = new ModelAndView();
			
			List<Drug> dlist = new ArrayList<Drug>() ;
			session.setAttribute("dlist", dlist);
			
			//HttpSession session = (HttpSession) request.getSession();
			User u = (User) session.getAttribute("user");
			String pmobile = request.getParameter("pmobile");
			
			Patient current_patient = patientDao.getPatient(pmobile);
			session.setAttribute("current_patient", current_patient);
			
			//mv.addObject("jobs", jobsDao.listCompany(u.getCompany()));
			//mv.addObject("joblist", job);
			mv.setViewName("search-drug");
			return mv;
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while adding job");
		}
	}
	
	@RequestMapping(value = "/searchdrug.htm", method = RequestMethod.POST)
	public ModelAndView searchDrug(HttpServletRequest request,HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		System.out.println(request.getParameter("dname"));
		List<Drug> dlist = drugDao.getAllDrug(request.getParameter("dname"));
		mv.addObject("drugList", dlist);
		System.out.println(dlist);
		if (dlist.isEmpty())
			System.out.println("The returned list is empty");
		for (Drug drug : dlist) {
			System.out.println("The matching patient are : " + drug.getDrugName());
		}
				
		mv.setViewName("drug-inter");

		return mv;			
		
	}
	
	@RequestMapping(value = "/finalDrug.htm", method = RequestMethod.POST)
	protected ModelAndView adddrug(HttpServletRequest request, HttpSession session) throws Exception {		
		
		ModelAndView mv = new ModelAndView();
		System.out.println(request.getParameter("drugid"));
		Drug drug = drugDao.getDrug(request.getParameter("drugid"));
		//session.setAttribute("dlist", dlist);
		
		if(drug != null)
		{
			List<Drug> drugList = (List<Drug>) session.getAttribute("dlist");
			drugList.add(drug);
			session.setAttribute("dlist", drugList);
			System.out.println("Drug Added");
		} else {
			return new ModelAndView("error", "errorMessage", "error while adding job");			
		}
			
		mv.addObject("finalPatient",session.getAttribute("current_patient"));
		mv.addObject("drugList",session.getAttribute("dlist"));
		mv.setViewName("patient-order");

		return mv;		
	}
	
	@RequestMapping(value = "/add-drug.htm", method = RequestMethod.POST)
	protected ModelAndView moreDrug(HttpServletRequest request, HttpSession session) throws Exception {	
		return new ModelAndView("search-drug");
	}
	
	
	@RequestMapping(value = "/check-interactions.htm", method = RequestMethod.POST)
	protected ModelAndView checkInteractions(HttpServletRequest request, HttpSession session) throws Exception {	
		 
		 ModelAndView mv = new ModelAndView();
		 String interStr = "";
		 List<Drug> dlist = (List<Drug>)session.getAttribute("dlist");
		 System.out.println("size"+dlist.size());
			for (int i=0;i<dlist.size();i++) {
				Drug drug = (Drug)dlist.get(i);
			    interStr += "+" + drug.getDrugcomid();
			    System.out.println(i+ " "+interStr);
			}
			
	        try
	        {
	            interStr = interStr.substring(1);
	        }catch(StringIndexOutOfBoundsException e){
	        	return new ModelAndView("error", "errorMessage", "error while checking interactions");
	        }
	        System.out.println("done and dusted");
	        String url = "https://rxnav.nlm.nih.gov/REST/interaction/list.json?rxcuis="+interStr;
	        //String url = "https://rxnav.nlm.nih.gov/REST/interaction/list.json?rxcuis=123+345";
	        String finalInteractions = "";

	        URL obj;
	        try {
	            obj = new URL(url);
	            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	            con.setRequestMethod("GET");

	            int responseCode = con.getResponseCode();

	            System.out.println(responseCode);
	            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            String inputLine;
	            StringBuffer response = new StringBuffer();

	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();

	            //print result
	            //System.out.println(response.toString());
	            Object jobj = new JSONParser().parse(response.toString());

	            JSONObject jo = (JSONObject) jobj;
	            //JSONObject job = (JSONObject) jo.get("nlmDisclaimer");
	            JSONArray address = (JSONArray) jo.get("fullInteractionTypeGroup");

	            for (Object o : address) {
	                JSONObject objt = (JSONObject) o;
	                String strTemp = (String) objt.get("sourceDisclaimer");
	                //System.out.println(strTemp);
	                JSONArray add2 = (JSONArray) objt.get("fullInteractionType");
	                for (Object obj2 : add2) {
	                    JSONObject objTemp = (JSONObject) obj2;
	                    String strTemp2 = (String) objTemp.get("comment");
	                    finalInteractions = finalInteractions + "~" + strTemp2;
	                    //System.out.println(strTemp2);
	                    JSONArray add3 = (JSONArray) objTemp.get("interactionPair");
	                    for (Object obj3 : add3) {
	                        JSONObject objTemp3 = (JSONObject) obj3;
	                        String strTemp3 = (String) objTemp3.get("description");
	                        finalInteractions = finalInteractions + "~" + strTemp3;
	                        if (!strTemp3.isEmpty()) {
	                            break;
	                        }
	                        //System.out.println(strTemp3);
	                    }
	                }
	            }
	        } catch (MalformedURLException ex) {
	        	System.out.println("first");
	        	return new ModelAndView("error", "errorMessage", "Please enter proper drug ID");
	        } catch (IOException ex) {
	        	System.out.println("second");
	        	return new ModelAndView("error", "errorMessage", "Connection Time-Out");	            
	        } catch (ParseException ex) {
	        	System.out.println("third");
	        	return new ModelAndView("error", "errorMessage", "API Output is not proper.");	
	        } catch (NullPointerException ex) {
	        	System.out.println(finalInteractions);
	        	System.out.println("fourth");
	        	return new ModelAndView("error", "errorMessage", "API did not give any interactions.");	
	        }
	        
	        Boolean interactionCheck;
			if (finalInteractions.isEmpty()) {
	            interactionCheck = Boolean.FALSE;
	        }
	        else
	        {
	            interactionCheck = Boolean.TRUE;
	            //int cnt = patient.getInteractionCount();
	            //patient.setInteractionCount(cnt+1);
	        }
			 
		if(interactionCheck)
		{
			mv.addObject("interaction",finalInteractions);
			mv.setViewName("show-interactions");
		}else {
			mv.setViewName("patient-order");
		}
		return mv;
	}
	
//	@RequestMapping(value = "/go-home.htm", method = RequestMethod.POST)
//	protected ModelAndView goHome(HttpServletRequest request, HttpSession session) throws Exception {	
//		return new ModelAndView("search-drug");
//	}
	@RequestMapping(value = "/logout.htm", method = RequestMethod.POST)
	protected ModelAndView goLogout(HttpServletRequest request, HttpSession session) throws Exception {	
		System.out.println("Session invalidated");
		session.setAttribute("user", null);
		session.invalidate();  
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/doctor-home.htm", method = RequestMethod.POST)
	protected ModelAndView goHomePage(HttpServletRequest request, HttpSession session) throws Exception {	
		return new ModelAndView("searchPatient");
	}
	
	@RequestMapping(value = "/order-summary.htm", method = RequestMethod.POST)
	public ModelAndView showPdfReport(@ModelAttribute("patient") Patient patient,ModelMap model,BindingResult result,HttpServletRequest request,HttpSession session) throws Exception
	{
		model.addAttribute("finalPatient",session.getAttribute("current_patient"));
		model.addAttribute("drugList",session.getAttribute("dlist"));
		
		View v = new PdfReport();
		return new ModelAndView(v);
	}

}
