/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.data.jpa.domain.City;

@Component("cityService")
class CityServiceImpl implements CityService
{

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository)
    {
        this.cityRepository = cityRepository;
    }

    @Override
    public City addCity()
    {
        City city = new City(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        cityRepository.save(city);
        return city;
    }

    @Override
    public List<City> getAllCities()
    {
        return cityRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteCity(String name,
                           String country)
    {
        cityRepository.deleteByNameAndCountry(name, country);
    }

}
