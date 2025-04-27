package com.example.kyc.service

import com.example.kyc.api.model.request.LegalEntityResearchRequest
import com.example.kyc.api.model.request.WebsiteResearchRequest
import com.example.kyc.api.model.response.LegalEntityResearchResponse
import com.example.kyc.api.model.response.WebsiteResearchResponse
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.prompt.PromptTemplate
import org.springframework.stereotype.Service

@Service
class ResearchService(
    private val chatClient: ChatClient,
) {
    fun legalEntity(request: LegalEntityResearchRequest): LegalEntityResearchResponse? =
        chatClient
            .prompt(
                PromptTemplate(
                    """
                    You are an expert in extracting information about Ukrainian legal entities based on publicly available data, similar to the information found on resources like YouControl and Opendatabot. Given the following EDRPOU (ЄДРПОУ) code:

                    {edrpou}
                    
                    Please identify and extract the following information for this legal entity. If a particular piece of information cannot be definitively determined or is not publicly available, please indicate "Not Found" for that value.
                    
                    Specifically, retrieve:
                    
                    1.  **EDRPOU (ЄДРПОУ):** The unique identification code of the legal entity.
                    2.  **Company Name in Ukrainian (Повна назва юридичної особи):** The full legal name of the company in Ukrainian.
                    3.  **Registration Date (Дата державної реєстрації):** The date when the legal entity was officially registered. Use YYYY-MM-DD format if possible.
                    4.  **Legal Address (Юридична адреса):** The official registered address of the legal entity in Ukraine.
                    5.  **Director (Керівник):** The full name of the current director or head of the legal entity.
                    6.  **Main Activity Description in Ukrainian (Основний вид діяльності):** A brief description of the primary business activity of the entity in Ukrainian.
                    7.  **Statutory Capital (Статутний капітал):** The amount of the registered capital of the legal entity, including the currency if specified.
                    
                    Additionally, if readily available in public sources, please also try to identify and include the following:
                    
                    8.  **Current Status (Стан юридичної особи):** The current legal status of the entity (e.g., "Active," "Terminated," "In Bankruptcy"). Provide in Ukrainian if possible.
                    9.  **List of Founders/Beneficial Owners (Засновники/Кінцеві бенефіціарні власники):** A list of the individuals or legal entities that are the founders or ultimate beneficial owners. Include their names if available.
                    10. **Contact Phone Number (Контактний телефон):** Any publicly listed contact phone number for the entity.
                    11. **Contact Email (Контактна електронна пошта):** Any publicly listed contact email address for the entity.
                    """.trimIndent(),
                ).create(
                    mapOf(
                        "edrpou" to request.edrpou,
                    ),
                ),
            ).call()
            .entity(
                LegalEntityResearchResponse::class.java,
            )

    fun website(request: WebsiteResearchRequest): WebsiteResearchResponse? =
        chatClient
            .prompt(
                PromptTemplate(
                    """
                    Please identify and extract the following information from {url}, if present:

                    1.  **Business Name (DBA/Trade Name):** The name the business uses publicly.
                    2.  **Industry/Nature of Business:** A brief description of what the business does (e.g., "online retailer selling handmade jewelry," "software company providing marketing automation tools," "local restaurant serving Italian cuisine").
                    3.  **Products/Services Offered:** A concise list or summary of the main products or services they provide.
                    4.  **Physical Business Address (if mentioned):** The physical location of the business. If multiple locations are mentioned, provide the primary one or indicate multiple locations.
                    5.  **Contact Email (if found):** The primary email address for contact.
                    6.  **Contact Phone Number (if found):** The main phone number for contact.
                    7.  **Shipping Policy (brief summary if available):** A very short overview of their shipping practices (e.g., "ships domestically and internationally," "offers free shipping on orders over $50").
                    8.  **Return/Refund Policy (brief summary if available):** A very short overview of their return/refund practices (e.g., "30-day return policy," "no returns on personalized items").
                    9.  **Social Media Links (if listed):** URLs or handles for their social media profiles (e.g., Facebook, Instagram, Twitter).
                    10. **About Us (very brief summary of their mission or history if available):** A one or two-sentence summary of their "About Us" information.
                    11. **Payment Methods Accepted (if logos or names are visible):** List the payment methods they indicate they accept (e.g., Visa, Mastercard, PayPal).
                    
                    If a particular piece of information is not found on the website, please indicate "Not Found" for that item.
                    
                    Present your findings in a clear, structured format, suitable for parsing into a data structure. For example:
                    """.trimIndent(),
                ).create(
                    mapOf(
                        "url" to request.url,
                    ),
                ),
            ).call()
            .entity(
                WebsiteResearchResponse::class.java,
            )
}